package org.simplepresenter

interface ViewDispatcher {

    fun dispatchCommand(view: Any, command: ViewCommand)
}