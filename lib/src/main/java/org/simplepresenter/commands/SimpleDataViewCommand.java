package org.simplepresenter.commands;

import org.simplepresenter.ViewCommand;

public class SimpleDataViewCommand implements ViewCommand {

    private final String data;

    public SimpleDataViewCommand(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleDataViewCommand that = (SimpleDataViewCommand) o;

        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SimpleDataViewCommand{" +
                "data='" + data + '\'' +
                '}';
    }
}
