package org.github.kommandpresenter

import org.github.kommandpresenter.ViewCommand

interface ViewDispatcher {

    fun dispatchCommand(view: Any, command: ViewCommand)
}