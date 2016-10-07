package org.simplepresenter.commands

import org.simplepresenter.ViewCommand

interface DispatchedViewCommand : ViewCommand {

    var isDispatched: Boolean
}