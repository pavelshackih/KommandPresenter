package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

interface CommandBehavior<in T : ViewCommand> {

    fun beforeApply(command: T)

    fun afterDispatched(command: T)
}