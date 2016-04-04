package org.simplepresenter

class TargetViewDelegate(view: PresenterView<TargetPresenter>) : ViewDelegate<TargetPresenter>(view) {

    override var isResumed: Boolean
        get() = true
        set(value) {
        }

    override fun delegateCommand(command: ViewCommand) {
    }

}