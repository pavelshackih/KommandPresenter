package org.simplepresenter

interface PresenterView<out P : Presenter> {

    fun createPresenter(): P

    val presenter: P

    fun dispatch(viewCommand: ViewCommand)
}