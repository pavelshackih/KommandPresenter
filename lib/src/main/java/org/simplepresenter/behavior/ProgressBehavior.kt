package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

class ProgressBehavior : AbstractCommandBehavior() {

    override fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        return list
    }
}