package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.ViewCommand
import org.github.kommandpresenter.behavior.CommandBehavior
import java.util.*

class DelegatedBehavior(list: List<CommandBehavior>) : CommandBehavior {

    private val delegates: List<CommandBehavior>

    init {
        delegates = ArrayList(list)
    }

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        var result: List<ViewCommand> = ArrayList(list)
        delegates.forEach {
            result = it.beforeApply(current, result)
        }
        return result
    }

    override fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        var result: List<ViewCommand> = ArrayList(list)
        delegates.forEach {
            result = it.afterDispatched(current, result)
        }
        return result
    }
}