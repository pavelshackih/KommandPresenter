package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

abstract class TypedCommandBehavior(private val type: Class<*>) : CommandBehavior {

    override fun beforeApply(command: ViewCommand) {
    }

    override fun afterDispatched(command: ViewCommand) {
    }

    override fun isSupported(command: ViewCommand): Boolean = type == command.javaClass
}