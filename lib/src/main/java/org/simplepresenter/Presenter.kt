package org.simplepresenter

import org.simplepresenter.behavior.DelegatedBehavior
import java.lang.ref.WeakReference
import java.util.*

open class Presenter {

    private val behavior: DelegatedBehavior
    private var viewRef: WeakReference<ViewDelegate>? = null

    var commands: MutableList<ViewCommand> = LinkedList()

    init {
        behavior = DelegatedBehavior(CommandEngine.Bridge.currentEngine.behaviorFactory.behaviors)
    }

    // public api -->

    open fun onViewCreated() {
    }

    open fun onViewDestroyed() {
    }

    fun applyCommand(command: ViewCommand) {
        behavior.beforeApply(command)
        commands.add(command)
        if (isViewResumed) {
            dispatchCommand(command)
        }
    }

    // internal api -->

    val isViewResumed: Boolean
        get() = viewRef?.get()?.isResumed ?: false

    fun bind(viewDelegate: ViewDelegate) {
        clearReferenceToView()
        viewRef = WeakReference(viewDelegate)
    }

    fun onRestoreView() = commands.forEach { dispatchCommand(it) }

    fun dispatchCommand(command: ViewCommand) {
        viewRef?.get()?.delegateCommand(command)
        behavior.afterDispatched(command)
    }

    fun clearReferenceToView() {
        viewRef?.clear()
        viewRef = null
    }
}