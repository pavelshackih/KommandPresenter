package org.simplepresenter;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class Presenter implements ObservablePresenter {

    private WeakReference<ViewDelegate<?>> delegateReference;

    private List<ViewCommand> commands = new LinkedList<>();
    private ViewCommand lastCommand;

    private CommandObserver observer;

    private CommandObserver getObserver() {
        if (observer == null) {
            observer = createCommandObserver();
        }
        return observer;
    }

    public CommandObserver createCommandObserver() {
        return new CommandObserver(this);
    }

    public void onViewCreated() {
    }

    public void onViewDestroyed() {
    }

    public final void applyViewState(ViewCommand command) {
        getObserver().beforeApplyCommand(command);
        commands.add(command);
        lastCommand = command;
        if (isViewResumed()) {
            dispatchCommand(command);
        }
    }

    private boolean isViewResumed() {
        return delegateReference != null && delegateReference.get() != null && delegateReference.get().isResumed();
    }

    public void bind(ViewDelegate<?> viewDelegate) {
        clearReferenceToView();
        delegateReference = new WeakReference<ViewDelegate<?>>(viewDelegate);
    }

    void onRestoreView() {
        for (int i = 0; i < commands.size(); i++) {
            dispatchCommand(commands.get(i));
        }
    }

    public void dispatchCommand(ViewCommand command) {
        if (delegateReference != null && delegateReference.get() != null) {
            delegateReference.get().delegateCommand(command);
            getObserver().afterCommandDispatched(command);
        }
    }

    public void clearReferenceToView() {
        if (delegateReference != null) {
            delegateReference.clear();
        }
        delegateReference = null;
    }

    List<ViewCommand> getCommands() {
        return commands;
    }

    @Override
    public final void applyCommands(Action f) {
        commands = f.invoke(commands);
    }
}
