package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

abstract class AbstractCommandBehavior : CommandBehavior {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> = list

    override fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> = list
}