package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.behavior.CommandBehavior
import org.github.kommandpresenter.behavior.CommandBehaviorFactory

open class DefaultBehaviorFactory : CommandBehaviorFactory {

    private val list by lazy { createList() }

    protected open fun createList(): List<CommandBehavior> =
            listOf(DispatchedCommandBehavior(), ProgressBehavior())

    override val behaviors: List<CommandBehavior> = list
}