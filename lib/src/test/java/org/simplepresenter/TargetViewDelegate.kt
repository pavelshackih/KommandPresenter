package org.simplepresenter

class TargetViewDelegate() : ViewDelegate<TargetPresenter>() {

    override var isResumed: Boolean
        get() = true
        set(value) {
        }

    override fun delegateCommand(command: ViewCommand) {
    }

}