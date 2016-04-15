package org.simplepresenter.commands;

public class PercentProgressViewCommand extends ProgressViewCommand {

    private final int percent;

    public PercentProgressViewCommand(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PercentProgressViewCommand that = (PercentProgressViewCommand) o;

        return percent == that.percent;
    }

    @Override
    public int hashCode() {
        return percent;
    }

    @Override
    public String toString() {
        return "PercentProgressViewCommand{" +
                "percent=" + percent +
                '}';
    }
}