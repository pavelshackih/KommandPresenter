package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand
import org.simplepresenter.commands.ProgressViewCommand

class ProgressBehavior : TypedCommandBehavior(ProgressViewCommand::class.java) {

    override fun beforeApply(command: ViewCommand) {
    }

    override fun afterDispatched(command: ViewCommand) {
    }
}