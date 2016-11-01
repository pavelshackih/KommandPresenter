package org.github.kommandpresenter.commands

interface DataCommand<out D> : SingleInstanceViewCommand, DispatchedViewCommand {

    val data: D
}
