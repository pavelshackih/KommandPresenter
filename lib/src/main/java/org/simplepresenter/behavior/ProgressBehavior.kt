package org.simplepresenter.behavior

import org.simplepresenter.commands.ProgressViewCommand

class ProgressBehavior : AbstractCommandBehavior<ProgressViewCommand>() {

    override fun beforeApply(command: ProgressViewCommand) {
    }

    override fun afterDispatched(command: ProgressViewCommand) {
    }
}