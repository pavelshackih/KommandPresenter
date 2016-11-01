package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.ViewCommand

abstract class AbstractCommandBehavior : CommandBehavior {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> = list

    override fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> = list
}