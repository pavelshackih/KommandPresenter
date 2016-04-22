package org.simplepresenter;

import org.junit.Before;
import org.junit.Test;
import org.simplepresenter.commands.OneTimeViewCommand;
import org.simplepresenter.commands.ProgressViewCommand;
import org.simplepresenter.commands.StringDataViewCommand;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PresenterTest {

    TargetPresenter presenter;

    @Before
    public void setUp() {
        presenter = new TargetPresenter();
    }

    @Test
    public void testProgressCommand1() {
        List<ViewCommand> expected = new LinkedList<>();
        expected.add(new StringDataViewCommand("test1"));
        expected.add(new StringDataViewCommand("test2"));
        expected.add(ProgressViewCommand.INSTANCE);

        presenter.applyViewState(new StringDataViewCommand("test1"));
        presenter.applyViewState(ProgressViewCommand.INSTANCE);
        presenter.applyViewState(new StringDataViewCommand("test2"));
        presenter.applyViewState(ProgressViewCommand.INSTANCE);

        assertEquals(expected, presenter.getCommands());
    }

    @Test
    public void testProgressCommand2() {
        List<ViewCommand> expected = new LinkedList<>();
        expected.add(new StringDataViewCommand("test1"));
        expected.add(new StringDataViewCommand("test2"));
        expected.add(new StringDataViewCommand("test3"));

        presenter.applyViewState(new StringDataViewCommand("test1"));
        presenter.applyViewState(ProgressViewCommand.INSTANCE);
        presenter.applyViewState(new StringDataViewCommand("test2"));
        presenter.applyViewState(ProgressViewCommand.INSTANCE);
        presenter.applyViewState(new StringDataViewCommand("test3"));

        assertEquals(expected, presenter.getCommands());
    }

    @Test
    public void testOneTimeCommand() {
        List<ViewCommand> expected = new LinkedList<>();
        expected.add(new StringDataViewCommand("test1"));
        expected.add(OneTimeCommand.INSTANCE);

        TargetView view = new TargetView();
        view.setResumed(false);
        view.getPresenter().applyViewState(new StringDataViewCommand("test1"));
        view.getPresenter().applyViewState(OneTimeCommand.INSTANCE);
        assertEquals(expected, view.getPresenter().getCommands());
        view.setResumed(true);
        view.getPresenter().onRestoreView();
        expected.remove(1);
        assertEquals(expected, view.getPresenter().getCommands());
    }

    static class OneTimeCommand implements OneTimeViewCommand {
        public static final OneTimeCommand INSTANCE = new OneTimeCommand();
    }
}
