package ru.sbt.test.refactoring.state;

import ru.sbt.test.refactoring.state.behavior.Behavior;
import ru.sbt.test.refactoring.state.behavior.MacroAction;

/**
 * Created by Maxim on 12/6/2015.
 */
abstract public class State {
    protected Behavior behavior;

    public void addMacro(String macroName, MacroAction macro) {
        behavior.addMacro(macroName, macro);
    }

    public void performAction(String actionName) {
        behavior.performAction(actionName, this);
    }

    public abstract void printMetrics();
}
