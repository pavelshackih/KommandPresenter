package org.github.kommandpresenter.behavior

import org.github.kommandpresenter.ViewCommand

class SingleInstanceCommandBehavior : AbstractCommandBehavior() {

    override fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand> {
        return list.filter { it.javaClass != current.javaClass }
    }
}