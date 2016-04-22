package org.simplepresenter;

import android.support.annotation.NonNull;

import org.simplepresenter.commands.DataCommand;
import org.simplepresenter.commands.ErrorViewCommand;
import org.simplepresenter.commands.ProgressViewCommand;

public abstract class LcePresenterFragment<D, P extends Presenter> extends PresenterFragment<P> {

    @Override
    public void dispatchCommand(@NonNull ViewCommand viewCommand) {
        if (viewCommand instanceof ProgressViewCommand) {
            onProgress();
        } else if (viewCommand instanceof ErrorViewCommand) {
            onError(((ErrorViewCommand) viewCommand).getThrowable());
        } else if (viewCommand instanceof DataCommand<?>) {
            //noinspection unchecked
            onData((D) ((DataCommand) viewCommand).getData());
        }
    }

    public void onProgress() {
    }

    public void onError(Throwable throwable) {
    }

    public void onData(D data) {
    }
}