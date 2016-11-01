package org.github.kommandpresenter.commands

import org.github.kommandpresenter.ViewCommand

interface DispatchedViewCommand : ViewCommand {

    var isDispatched: Boolean
}