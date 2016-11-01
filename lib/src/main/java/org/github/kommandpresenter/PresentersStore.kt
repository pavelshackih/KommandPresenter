package org.github.kommandpresenter

import org.github.kommandpresenter.Presenter

interface PresentersStore {

    fun savePresenter(id: Int, presenter: Presenter)

    fun loadPresenter(id: Int): Presenter

    fun deletePresenter(id: Int): Unit
}