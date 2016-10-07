package org.simplepresenter.behavior

import org.simplepresenter.commands.DispatchedViewCommand

class DispatchedCommandBehavior : AbstractCommandBehavior<DispatchedViewCommand>() {

    override fun afterDispatched(command: DispatchedViewCommand) {
        command.isDispatched = true
    }
}