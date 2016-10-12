package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand
import org.simplepresenter.commands.DispatchedViewCommand

class DispatchedCommandBehavior : AbstractCommandBehavior() {

    override fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        if (current is DispatchedViewCommand) {
            current.isDispatched = true
        }
        return list
    }
}