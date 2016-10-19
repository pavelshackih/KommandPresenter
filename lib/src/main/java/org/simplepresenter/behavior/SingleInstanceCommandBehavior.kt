package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

class SingleInstanceCommandBehavior : AbstractCommandBehavior() {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        return list.filter { it.javaClass != current.javaClass }
    }
}