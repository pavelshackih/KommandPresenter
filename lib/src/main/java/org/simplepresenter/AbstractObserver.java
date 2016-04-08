package org.simplepresenter;

import android.support.annotation.NonNull;

import org.simplepresenter.ObservablePresenter.Action;
import org.simplepresenter.ObservablePresenter.CommandPredicate;
import org.simplepresenter.commands.DistinctViewCommand;
import org.simplepresenter.commands.OneTimeViewCommand;
import org.simplepresenter.commands.SingleTopViewCommand;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObserver {

    private ObservablePresenter observable;

    public AbstractObserver(ObservablePresenter observable) {
        this.observable = observable;
    }

    public final void applyCommands(Action f) {
        observable.applyCommands(f);
    }

    boolean isDistinct(@NonNull ViewCommand command) {
        return DistinctViewCommand.class.isAssignableFrom(command.getClass());
    }

    boolean isSingleTop(@NonNull ViewCommand command) {
        return SingleTopViewCommand.class.isAssignableFrom(command.getClass());
    }

    boolean isOneTime(@NonNull ViewCommand command) {
        return OneTimeViewCommand.class.isAssignableFrom(command.getClass());
    }

    void filter(final CommandPredicate predicate) {
        applyCommands(new Action() {
            @Override
            public List<ViewCommand> invoke(List<ViewCommand> list) {
                List<ViewCommand> result = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (predicate.invoke(list.get(i))) {
                        result.add(list.get(i));
                    }
                }
                return result;
            }
        });
    }
}
