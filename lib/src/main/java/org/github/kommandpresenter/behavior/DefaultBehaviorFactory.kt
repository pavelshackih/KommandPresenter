package org.github.kommandpresenter.behavior

open class DefaultBehaviorFactory : CommandBehaviorFactory {

    private val list by lazy { createList() }

    protected open fun createList(): List<CommandBehavior> =
            listOf(DispatchedCommandBehavior(), ProgressBehavior())

    override val behaviors: List<CommandBehavior> = list
}