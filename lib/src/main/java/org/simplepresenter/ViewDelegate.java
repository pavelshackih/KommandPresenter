package org.simplepresenter;

public abstract class ViewDelegate<P extends Presenter> {
    
    private PresenterView<P> view;
    private P presenter;
    private boolean isResumed;
    private boolean isDead;
    private boolean isRestoring;

    public PresenterView<P> getView() {
        return view;
    }

    public void setView(PresenterView<P> view) {
        this.view = view;
    }

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public boolean isResumed() {
        return isResumed;
    }

    public void setResumed(boolean resumed) {
        isResumed = resumed;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isRestoring() {
        return isRestoring;
    }

    public void setRestoring(boolean restoring) {
        isRestoring = restoring;
    }

    public abstract void delegateCommand(ViewCommand command);
}
