package org.github.kommandpresenter.commands

import org.github.kommandpresenter.commands.DispatchedViewCommand
import org.github.kommandpresenter.commands.SingleInstanceViewCommand

interface DataCommand<out D> : SingleInstanceViewCommand, DispatchedViewCommand {

    val data: D
}
