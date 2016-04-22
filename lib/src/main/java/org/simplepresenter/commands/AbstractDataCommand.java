package org.simplepresenter.commands;

public abstract class AbstractDataCommand<D> implements DataCommand<D> {

    private final D data;
    private boolean dispatched;

    public AbstractDataCommand(D data) {
        this.data = data;
    }

    @Override
    public D getData() {
        return data;
    }

    @Override
    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

    @Override
    public boolean isDispatched() {
        return dispatched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractDataCommand<?> that = (AbstractDataCommand<?>) o;

        if (dispatched != that.dispatched) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (dispatched ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbstractDataCommand{" +
                "data=" + data +
                ", dispatched=" + dispatched +
                '}';
    }
}
