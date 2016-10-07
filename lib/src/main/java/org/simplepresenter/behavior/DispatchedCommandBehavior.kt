package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand
import org.simplepresenter.commands.DispatchedViewCommand

class DispatchedCommandBehavior : TypedCommandBehavior(DispatchedViewCommand::class.java) {

    override fun afterDispatched(command: ViewCommand) {
        if (command is DispatchedViewCommand) {
            command.isDispatched = true
        }
    }
}