package org.simplepresenter

@Suppress("unused")
class DefaultViewDispatcher : ViewDispatcher {

    override fun dispatchCommand(view: Any, command: ViewCommand) {
        if (view is PresenterView<*>) {
            view.dispatch(command)
        }
    }
}