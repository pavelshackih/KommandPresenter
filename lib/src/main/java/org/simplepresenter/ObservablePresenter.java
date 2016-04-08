package org.simplepresenter;

import java.util.List;

public interface ObservablePresenter {

    void applyCommands(Action f);

    interface Action {
        List<ViewCommand> invoke(List<ViewCommand> list);
    }

    interface CommandPredicate {
        boolean invoke(ViewCommand command);
    }
}
