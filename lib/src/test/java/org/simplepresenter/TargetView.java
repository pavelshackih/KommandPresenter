package org.simplepresenter;

import android.support.annotation.NonNull;

public class TargetView implements PresenterView<TargetPresenter> {

    private TargetPresenter _presenter = new TargetPresenter();
    private TargetViewDelegate viewDelegate = new TargetViewDelegate();

    public TargetView() {
        _presenter.bind(viewDelegate);
    }

    @NonNull
    @Override
    public TargetPresenter createPresenter() {
        return _presenter;
    }

    @NonNull
    @Override
    public TargetPresenter getPresenter() {
        return _presenter;
    }

    @Override
    public void dispatchCommand(@NonNull ViewCommand viewCommand) {
    }

    public void setResumed(boolean resumed) {
        viewDelegate.setResumed(resumed);
    }
}
