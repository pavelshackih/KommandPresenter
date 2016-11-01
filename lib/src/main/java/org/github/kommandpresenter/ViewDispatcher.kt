package org.github.kommandpresenter

interface ViewDispatcher {

    fun dispatchCommand(view: Any, command: ViewCommand)
}