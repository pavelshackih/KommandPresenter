package org.github.kommandpresenter

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class PresenterFragment<out P : Presenter> : Fragment(), PresenterView<P> {

    @Suppress("LeakingThis")
    private val delegate = PresenterViewDelegate(this)

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

    @Suppress("UNCHECKED_CAST")
    override val presenter: P
        get() = delegate.presenter as P
}
