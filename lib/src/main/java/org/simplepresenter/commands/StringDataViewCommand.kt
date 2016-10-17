package org.simplepresenter.commands

import org.simplepresenter.ViewCommand

data class StringDataViewCommand(val data: String, override var isDispatched: Boolean = false) :
        ViewCommand, DistinctViewCommand, DispatchedViewCommand