package org.simplepresenter

import java.util.*

internal object PresenterHolder {

    private val map = HashMap<Int, Presenter>()

    fun registerPresenter(presenter: Presenter) {
        map.put(presenter.hashCode(), presenter)
    }

    fun findPresenterById(id: Int) = map[id]

    fun removePresenterById(id: Int) = map.remove(id)
}