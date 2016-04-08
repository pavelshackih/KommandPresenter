package org.simplepresenter;

public class TargetView implements PresenterView<TargetPresenter> {

    private TargetPresenter _presenter = new TargetPresenter();
    private TargetViewDelegate viewDelegate = new TargetViewDelegate();

    public TargetView() {
        _presenter.bind(viewDelegate);
    }

    @Override
    public TargetPresenter createPresenter() {
        return _presenter;
    }

    @Override
    public TargetPresenter getPresenter() {
        return _presenter;
    }

    @Override
    public void dispatchCommand(ViewCommand viewCommand) {
    }

    public void setResumed(boolean resumed) {
        viewDelegate.setResumed(resumed);
    }
}
