package org.simplepresenter

class TargetView : PresenterView<TargetPresenter> {

    private var _presenter = TargetPresenter()

    init {
        _presenter.bind(TargetViewDelegate(this))
    }

    override fun createPresenter(): TargetPresenter = _presenter

    override val presenter: TargetPresenter
        get() = _presenter

    override fun dispatchCommand(command: ViewCommand) {
    }
}