package org.simplepresenter

abstract class ViewDelegate<P : Presenter>(view: PresenterView<P>) {

    open var view: PresenterView<P>? = null
    open var presenter: P? = null
    open var isResumed = false
    open var isDead = false
    open var isRestoring = false

    abstract fun delegateCommand(command: ViewCommand)
}
