package org.simplepresenter

import android.os.Handler
import java.lang.ref.WeakReference
import java.util.*

abstract class Presenter {

    private val uiHandler = Handler()
    private var delegateReference: WeakReference<PresenterViewDelegate<*>>? = null
    private val delegate: PresenterViewDelegate<*>?
        get() = delegateReference?.get()

    private val commands = LinkedList<ViewCommand>()
    private var lastCommand: ViewCommand? = null

    open fun onViewCreated() {
    }

    open fun onViewDestroyed() {
    }

    final fun applyViewState(command: ViewCommand) {
        uiHandler.post {
            if (delegate?.isResumed ?: false) {
                delegate?.view?.dispatchCommand(command)
            }
            commands.add(command)
            lastCommand = command
        }
    }

    // Internal methods goes here -->

    final internal fun bind(view: PresenterViewDelegate<*>) {
        delegateReference?.clear()
        delegateReference = WeakReference(view)
    }

    final internal fun clearReferenceToView() {
        delegateReference?.clear()
        delegateReference = null
    }

    internal fun onRestoreView() {
        commands.forEach { delegate?.view?.dispatchCommand(it) }
    }
}