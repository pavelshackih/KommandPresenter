package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.ViewCommand

interface CommandBehavior {

    fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand>

    fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand>
}