package org.simplepresenter

interface PresenterView<P : Presenter> {

    fun createPresenter(): P

    val presenter: P

    fun dispatchCommand(command: ViewCommand)
}