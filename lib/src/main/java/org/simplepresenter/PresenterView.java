package org.simplepresenter;

public interface PresenterView<P extends Presenter> {

    P createPresenter();

    P getPresenter();

    void dispatchCommand(ViewCommand viewCommand);
}
