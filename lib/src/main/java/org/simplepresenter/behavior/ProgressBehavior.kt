package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand
import org.simplepresenter.commands.ProgressViewCommand

class ProgressBehavior : AbstractCommandBehavior() {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        return list.filter { it != ProgressViewCommand }
    }
}