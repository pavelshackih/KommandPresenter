package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.ViewCommand
import org.github.kommandpresenter.commands.ProgressViewCommand
import org.github.kommandpresenter.behavior.AbstractCommandBehavior

class ProgressBehavior : AbstractCommandBehavior() {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        return list.filter { it != ProgressViewCommand }
    }
}