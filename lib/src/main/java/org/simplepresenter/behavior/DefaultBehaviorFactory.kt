package org.simplepresenter.behavior

import java.util.*

open class DefaultBehaviorFactory : CommandBehaviorFactory {

    private val list = ArrayList<CommandBehavior>()

    init {
        list.add(DispatchedCommandBehavior())
        list.add(ProgressBehavior())
    }

    override val behaviors: List<CommandBehavior> = list
}