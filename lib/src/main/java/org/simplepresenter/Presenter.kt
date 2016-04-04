package org.simplepresenter

import org.simplepresenter.commands.DistinctViewCommand
import org.simplepresenter.commands.OneTimeViewCommand
import java.lang.ref.WeakReference
import java.util.*

abstract class Presenter {

    private final val lock = Object()
    private var delegateReference: WeakReference<ViewDelegate<*>>? = null
    private val delegate: ViewDelegate<*>? = delegateReference?.get()

    internal var commands = LinkedList<ViewCommand>()
    internal var lastCommand: ViewCommand? = null

    open fun onViewCreated() {
    }

    open fun onViewDestroyed() {
    }

    final fun applyViewState(command: ViewCommand) {
        synchronized(lock) {
            commands = LinkedList(onNewCommand(command, commands))
            lastCommand = command
            if (delegate?.isResumed ?: false) {
                dispatchCommand(command)
            }
        }
    }

    fun onNewCommand(newCommand: ViewCommand, list: LinkedList<ViewCommand>): List<ViewCommand> {
        if (newCommand is DistinctViewCommand) {
            return list.filter { !it.javaClass.isAssignableFrom(newCommand.javaClass) } + newCommand
        }
        return list + newCommand
    }

    // Internal methods goes here -->

    final internal fun bind(view: ViewDelegate<*>) {
        delegateReference?.clear()
        delegateReference = WeakReference(view)
    }

    final internal fun clearReferenceToView() {
        delegateReference?.clear()
        delegateReference = null
    }

    internal fun onRestoreView() {
        commands.forEach { dispatchCommand(it) }
    }

    protected fun afterCommandExecuted(command: ViewCommand) {
        applyCommandStack { it.filter { it !is OneTimeViewCommand } }
    }

    protected fun beforeCommandExecuted(command: ViewCommand) {
    }

    internal fun dispatchCommand(command: ViewCommand) {
        beforeCommandExecuted(command)
        delegate?.delegateCommand(command)
        afterCommandExecuted(command)
    }

    protected fun applyCommandStack(f: (List<ViewCommand>) -> List<ViewCommand>) {
        commands = LinkedList(f(commands))
    }
}