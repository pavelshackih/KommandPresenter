package org.simplepresenter.commands

abstract class AbstractDataCommand<out D>(override val data: D) : DataCommand<D> {

    override var isDispatched: Boolean = false

    override fun <T : BehaviorCommand> behavior(): CommandBehavior<T> {
        throw UnsupportedOperationException("not implemented")
    }
}