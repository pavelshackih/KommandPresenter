package org.simplepresenter.commands;

public class ProgressViewCommand implements SingleTopViewCommand {

    public static final ProgressViewCommand INSTANCE = new ProgressViewCommand();

    @Override
    public String toString() {
        return "ProgressViewCommand";
    }
}
