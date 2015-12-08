package ru.sbt.test.refactoring.state.behavior;

import ru.sbt.test.refactoring.state.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maxim on 12/6/2015.
 */
public class MacroAction implements Action {
    private List<String> actionNames;
    private HashMap<String, Action> actions;

    public void init(HashMap<String, Action> actions) {
        this.actions = actions;
    }

    public MacroAction() {
        actionNames = new ArrayList<>();
    }

    public void addAction(String actionName) {
        actionNames.add(actionName);
    }

    @Override
    public void perform(State state) {
        if (actions == null) {
            return;
        }

        actionNames.stream()
                .filter(actionName -> actions.containsKey(actionName))
                .forEach(actionName -> actions.get(actionName).perform(state));
    }
}
