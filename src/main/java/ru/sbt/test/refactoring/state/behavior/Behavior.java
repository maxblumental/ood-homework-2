package ru.sbt.test.refactoring.state.behavior;

import ru.sbt.test.refactoring.state.State;

import java.util.HashMap;

/**
 * Created by Maxim on 12/6/2015.
 */
abstract public class Behavior {
    protected final HashMap<String, Action> actions;

    public Behavior() {
        actions = new HashMap<>();
    }

    public void addMacro(String macroName, MacroAction macro) {
        macro.init(actions);
        actions.put(macroName, macro);
    }

    public void addAction(String actionName, Action action) {
        actions.put(actionName, action);
    }

    public void performAction(String actionName, State state) {
        if (actions.containsKey(actionName)) {
            actions.get(actionName).perform(state);
        }
    }
}
