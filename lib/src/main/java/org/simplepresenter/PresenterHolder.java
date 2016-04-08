package org.simplepresenter;

import java.util.HashMap;
import java.util.Map;

public final class PresenterHolder {

    public static final PresenterHolder INSTANCE = new PresenterHolder();

    private PresenterHolder() {
    }

    private Map<Integer, Presenter> map = new HashMap<>();

    public void registerPresenter(Presenter presenter) {
        map.put(presenter.hashCode(), presenter);
    }


    public Presenter findPresenterById(int id) {
        return map.get(id);
    }

    public void removePresenterById(int id) {
        map.remove(id);
    }
}
