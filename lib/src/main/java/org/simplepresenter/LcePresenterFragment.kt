package org.simplepresenter

import org.simplepresenter.commands.DataCommand
import org.simplepresenter.commands.ErrorViewCommand
import org.simplepresenter.commands.ProgressViewCommand

@Suppress("unused")
abstract class LcePresenterFragment<in D, out P : Presenter> : PresenterFragment<P>() {

    override final fun dispatch(viewCommand: ViewCommand) {
        if (viewCommand is ProgressViewCommand) {
            onProgress()
        } else if (viewCommand is ErrorViewCommand) {
            onError(viewCommand.throwable)
        } else if (viewCommand is DataCommand<*>) {
            @Suppress("UNCHECKED_CAST")
            onData(viewCommand.data as D)
        } else {
            onElse(viewCommand)
        }
    }

    fun onProgress() {
    }

    fun onError(throwable: Throwable) {
    }

    fun onData(data: D) {
    }

    fun onElse(viewCommand: ViewCommand) {
    }
}