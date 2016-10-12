package org.simplepresenter.behavior

import org.simplepresenter.ViewCommand

interface CommandBehavior {

    fun beforeApply(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand>

    fun afterDispatched(current: ViewCommand, list: List<ViewCommand>): List<ViewCommand>
}