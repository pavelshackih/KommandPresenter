package org.simplepresenter.commands

interface DataCommand<out D> : SingleInstanceViewCommand, DispatchedViewCommand {

    val data: D
}
