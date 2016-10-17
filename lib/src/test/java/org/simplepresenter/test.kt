package org.simplepresenter

// internal implementations for test

internal class TestPresenter : Presenter()

internal fun TestPresenter.applyCommands(vararg commands: ViewCommand) {
    commands.forEach { this.applyCommand(it) }
}

internal class TargetView : PresenterView<TestPresenter> {

    override val presenter = TestPresenter()
    private val viewDelegate = TargetViewDelegate()

    init {
        presenter.bind(viewDelegate)
    }

    override fun createPresenter(): TestPresenter {
        return presenter
    }

    override fun dispatch(viewCommand: ViewCommand) {
    }

    fun setResumed(resumed: Boolean) {
        viewDelegate.isResumed = resumed
    }
}

internal class TargetViewDelegate : ViewDelegate() {

    override fun delegateCommand(command: ViewCommand) {
    }
}