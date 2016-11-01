package org.github.kommandpresenter

import android.util.SparseArray

class DefaultPresentersStore : PresentersStore {

    private val presenters = SparseArray<Presenter>()

    override fun savePresenter(id: Int, presenter: Presenter) {
        presenters.put(id, presenter)
    }

    override fun loadPresenter(id: Int): Presenter {
        return presenters[id]
    }

    override fun deletePresenter(id: Int) {
        presenters.remove(id)
    }
}