package org.simplepresenter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import java.util.concurrent.atomic.AtomicInteger

class PresenterViewDelegate(override var view: PresenterView<*>?) : ViewDelegate() {

    private companion object {
        internal const val PRESENTER_ID = "${BuildConfig.APPLICATION_ID}.PresenterViewDelegate.PRESENTER_ID"
        internal val ID_GENERATOR = AtomicInteger(0)
    }

    private var id: Int = 0
    private val store: PresentersStore
    private val uiHandler = Handler(Looper.getMainLooper())
    private var saveStateCalled: Boolean = false

    init {
        store = CommandEngine.Bridge.currentEngine.presentersStore
    }

    fun onCreate(state: Bundle?) {
        if (state == null) {
            id = ID_GENERATOR.incrementAndGet()
            presenter = view?.createPresenter()
            presenter?.bind(this)
            store.savePresenter(id, presenter as Presenter)
            isResumed = true
            presenter?.onViewCreated()
        } else {
            id = state.getInt(PRESENTER_ID)
            presenter = store.loadPresenter(id)
            isRestoring = true
            presenter?.bind(this)
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
        if (state == null) {
            throw IllegalStateException("State is null")
        }
        state.putInt(PRESENTER_ID, id)
        saveStateCalled = true
    }

    fun onDestroy() {
        if (!saveStateCalled) {
            presenter?.onViewDestroyed()
            store.deletePresenter(id)
        }
        dispose()
    }

    private fun dispose() {
        presenter?.clearReferenceToView()
        isDead = true
        presenter = null
        view = null
    }

    override fun delegateCommand(command: ViewCommand) {
        uiHandler.post { view?.dispatch(command) }
    }
}