package org.simplepresenter.commands

interface DataCommand<out D> : DistinctViewCommand, DispatchedViewCommand {

    val data: D
}
