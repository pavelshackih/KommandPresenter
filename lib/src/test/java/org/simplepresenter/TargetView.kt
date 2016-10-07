package org.simplepresenter

internal class TargetView : PresenterView<TargetPresenter> {

    override val presenter = TargetPresenter()
    private val viewDelegate = TargetViewDelegate()

    init {
        presenter.bind(viewDelegate)
    }

    override fun createPresenter(): TargetPresenter {
        return presenter
    }

    override fun dispatch(viewCommand: ViewCommand) {
    }

    fun setResumed(resumed: Boolean) {
        viewDelegate.isResumed = resumed
    }
}
