package org.simplepresenter;

import android.support.annotation.NonNull;

public interface PresenterView<P extends Presenter> {

    @NonNull
    P createPresenter();

    @NonNull
    P getPresenter();

    void dispatchCommand(@NonNull ViewCommand viewCommand);
}