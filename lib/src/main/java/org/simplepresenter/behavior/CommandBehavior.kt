package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

interface CommandBehavior{

    fun isSupported(command: ViewCommand): Boolean

    fun beforeApply(command: ViewCommand)

    fun afterDispatched(command: ViewCommand)
}