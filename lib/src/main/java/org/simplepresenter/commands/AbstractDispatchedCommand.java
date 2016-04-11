package org.simplepresenter.commands;

public abstract class AbstractDispatchedCommand implements DispatchedViewCommand {

    private boolean dispatched;

    @Override
    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

    @Override
    public boolean isDispatched() {
        return dispatched;
    }
}