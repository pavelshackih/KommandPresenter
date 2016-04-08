package org.simplepresenter.commands;

public final class ProgressViewCommand implements SingleTopViewCommand {

    public static ProgressViewCommand INSTANCE = new ProgressViewCommand();

    private ProgressViewCommand() {
    }

    @Override
    public String toString() {
        return "ProgressViewCommand";
    }
}
