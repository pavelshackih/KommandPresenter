package org.simplepresenter;

import org.simplepresenter.ObservablePresenter.CommandPredicate;
import org.simplepresenter.commands.DispatchedViewCommand;

public class CommandObserver extends AbstractObserver {

    public CommandObserver(ObservablePresenter observable) {
        super(observable);
    }

    public void beforeApplyCommand(ViewCommand command) {
        if (isDistinct(command)) {
            filter(new CommandPredicate() {
                @Override
                public boolean invoke(ViewCommand command) {
                    return !command.getClass().isAssignableFrom(command.getClass());
                }
            });
        }
        filter(new CommandPredicate() {
            @Override
            public boolean invoke(ViewCommand command) {
                return !isSingleTop(command);
            }
        });
    }

    public void afterCommandDispatched(final ViewCommand c) {
        if (isOneTime(c)) {
            filter(new CommandPredicate() {
                @Override
                public boolean invoke(ViewCommand command) {
                    return c != command;
                }
            });
        }
        if (c instanceof DispatchedViewCommand) {
            ((DispatchedViewCommand) c).setDispatched(true);
        }
    }
}
