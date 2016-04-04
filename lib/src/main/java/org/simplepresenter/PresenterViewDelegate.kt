package org.simplepresenter

import android.os.Bundle
import android.os.Handler

@Suppress("UNCHECKED_CAST")
class PresenterViewDelegate<P : Presenter>(view: PresenterView<P>) : ViewDelegate<P>(view) {

    private var saveStateCalled = false
    private val uiHandler = Handler()

    init {
        this.view = view
    }

    companion object {
        const val PRESENTER_ID = "PRESENTER_ID"
    }

    fun onCreate(state: Bundle?) {
        if (state == null) {
            presenter = view?.createPresenter();
            if (presenter != null) {
                PresenterHolder.registerPresenter(presenter!!)
            }
            presenter?.onViewCreated()
        } else {
            val presenterId = state.getInt(PRESENTER_ID)
            presenter = PresenterHolder.findPresenterById(presenterId) as P?
            if (presenter == null) {
                throw IllegalStateException("Can't find stored presenter with id: $presenterId for view: $view")
            }
            isRestoring = true
        }
        presenter?.bind(this)
    }

    override fun delegateCommand(command: ViewCommand) {
        uiHandler.post {
            view?.dispatchCommand(command)
        }
    }

    fun onPause() {
        isResumed = false
    }

    fun onResume() {
        isResumed = true
        if (isRestoring) {
            presenter?.onRestoreView()
        }
    }

    fun onSaveInstanceState(state: Bundle?) {
        state?.putInt(PRESENTER_ID, presenter?.hashCode() ?: 0)
        saveStateCalled = true
    }

    fun onDestroy() {
        if (!saveStateCalled) {
            presenter?.onViewDestroyed()
            PresenterHolder.removePresenterById(presenter?.hashCode() ?: 0)
        }
        presenter?.clearReferenceToView()
        isDead = true
        presenter = null
        view = null
    }
}