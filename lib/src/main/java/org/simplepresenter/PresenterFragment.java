package org.simplepresenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class PresenterFragment<P extends Presenter> extends Fragment implements PresenterView<P> {

    private final PresenterViewDelegate<P> delegate = new PresenterViewDelegate<>(this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        delegate.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        delegate.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        delegate.onDestroy();
    }

    @NonNull
    @Override
    public P getPresenter() {
        if (delegate.getPresenter() == null) {
            throw new IllegalStateException();
        }
        return delegate.getPresenter();
    }
}
