package org.github.kommandpresenter

import org.github.kommandpresenter.Presenter

interface PresenterView<out P : Presenter> {

    fun createPresenter(): P

    val presenter: P

    fun dispatch(viewCommand: ViewCommand)
}