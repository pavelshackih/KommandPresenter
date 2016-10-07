package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand
import java.util.*

class DelegatedBehavior(list: List<CommandBehavior>) : CommandBehavior {

    private val delegates: List<CommandBehavior>

    init {
        delegates = ArrayList(list)
    }

    override fun isSupported(command: ViewCommand): Boolean = true

    override fun beforeApply(command: ViewCommand) {
        delegates.forEach {
            if (it.isSupported(command)) {
                it.beforeApply(command)
            }
        }
    }

    override fun afterDispatched(command: ViewCommand) {
        delegates.forEach {
            if (it.isSupported(command)) {
                it.afterDispatched(command)
            }
        }
    }
}