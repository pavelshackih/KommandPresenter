package org.simplepresenter;

import android.os.Bundle;
import android.os.Handler;

public class PresenterViewDelegate<P extends Presenter> extends ViewDelegate<P> {

    public static final String PRESENTER_ID = "PRESENTER_ID";

    private boolean saveStateCalled;
    private Handler uiHandler = new Handler();

    public PresenterViewDelegate(PresenterView<P> view) {
        setView(view);
    }

    public void onCreate(Bundle state) {
        if (state == null) {
            setPresenter(getView().createPresenter());
            getPresenter().bind(this);
            PresenterHolder.INSTANCE.registerPresenter(getPresenter());
            setResumed(true);
            getPresenter().onViewCreated();
        } else {
            int presenterId = state.getInt(PRESENTER_ID);
            //noinspection unchecked
            setPresenter((P) PresenterHolder.INSTANCE.findPresenterById(presenterId));
            setRestoring(true);
            getPresenter().bind(this);
        }
    }

    public void onPause() {
        setResumed(false);
    }

    public void onResume() {
        setResumed(true);
        if (isRestoring()) {
            getPresenter().onRestoreView();
        }
    }

    public void onSaveInstanceState(Bundle state) {
        state.putInt(PRESENTER_ID, getPresenter().hashCode());
        saveStateCalled = true;
    }

    public void onDestroy() {
        if (!saveStateCalled) {
            getPresenter().onViewDestroyed();
            PresenterHolder.INSTANCE.removePresenterById(getPresenter().hashCode());
        }
        getPresenter().clearReferenceToView();
        setDead(true);
        setPresenter(null);
        setView(null);
    }

    @Override
    public void delegateCommand(final ViewCommand command) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                getView().dispatchCommand(command);
            }
        });
    }
}
