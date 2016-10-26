package org.simplepresenter

//  implementations for test

class TestPresenter : Presenter()

fun TestPresenter.applyCommands(vararg commands: ViewCommand) {
    commands.forEach { this.applyCommand(it) }
}

class TargetView : PresenterView<TestPresenter> {

    override val presenter = TestPresenter()
    private val viewDelegate = TestViewDelegate()

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

class TestViewDelegate : ViewDelegate() {

    override var isResumed: Boolean = true
        get() = field
        set(value) {
            field = value
        }

    override fun delegateCommand(command: ViewCommand) {
    }
}