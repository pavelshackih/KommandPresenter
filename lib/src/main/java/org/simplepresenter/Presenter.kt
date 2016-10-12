package org.simplepresenter

import org.simplepresenter.behavior.DelegatedBehavior
import java.lang.ref.WeakReference
import java.util.*

open class Presenter {

    private val behavior: DelegatedBehavior
    private var viewRef: WeakReference<ViewDelegate>? = null

    var commands: List<ViewCommand> = LinkedList()

    init {
        behavior = DelegatedBehavior(CommandEngine.Bridge.currentEngine.behaviorFactory.behaviors)
    }

    // public api -->

    open fun onViewCreated() {
    }

    open fun onViewDestroyed() {
    }

    fun applyCommand(command: ViewCommand) {
        commands = behavior.beforeApply(command, commands) + command
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
        commands = behavior.afterDispatched(command, commands)
    }

    fun clearReferenceToView() {
        viewRef?.clear()
        viewRef = null
    }
}