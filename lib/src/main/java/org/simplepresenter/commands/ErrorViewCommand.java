package org.simplepresenter.commands;

public class ErrorViewCommand implements SingleTopViewCommand {

    private final Throwable throwable;

    public ErrorViewCommand(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorViewCommand that = (ErrorViewCommand) o;

        return throwable != null ? throwable.equals(that.throwable) : that.throwable == null;

    }

    @Override
    public int hashCode() {
        return throwable != null ? throwable.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ErrorViewCommand{" +
                "throwable=" + throwable +
                '}';
    }
}
