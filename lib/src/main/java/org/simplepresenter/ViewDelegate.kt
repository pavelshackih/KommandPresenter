package org.simplepresenter

abstract class ViewDelegate {

    open var view: PresenterView<*>? = null
    open var presenter: Presenter? = null
    open var isResumed: Boolean = false
    open var isDead: Boolean = false
    open var isRestoring: Boolean = false

    abstract fun delegateCommand(command: ViewCommand)
}
