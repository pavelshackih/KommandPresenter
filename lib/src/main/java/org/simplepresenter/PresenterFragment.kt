package org.simplepresenter

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class PresenterFragment<P : Presenter> : Fragment(), PresenterView<P> {

    val delegate = PresenterViewDelegate<P>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delegate.onCreate(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        delegate.onPause()
    }

    override fun onResume() {
        super.onResume()
        delegate.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        delegate.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    override val presenter: P
        get() = delegate.presenter ?: throw IllegalStateException()
}