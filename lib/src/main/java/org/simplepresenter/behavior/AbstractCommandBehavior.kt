package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

abstract class AbstractCommandBehavior<in T : ViewCommand> : CommandBehavior<T> {

    override fun beforeApply(command: T) {
    }

    override fun afterDispatched(command: T) {
    }
}