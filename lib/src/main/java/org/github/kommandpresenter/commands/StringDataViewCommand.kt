package org.github.kommandpresenter.commands

import org.github.kommandpresenter.ViewCommand

data class StringDataViewCommand(val data: String, override var isDispatched: Boolean = false) :
        ViewCommand, SingleInstanceViewCommand, DispatchedViewCommand