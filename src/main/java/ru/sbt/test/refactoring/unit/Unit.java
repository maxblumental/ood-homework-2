package ru.sbt.test.refactoring.unit;

import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.state.behavior.MacroAction;

/**
 * Created by Maxim on 12/6/2015.
 */
abstract public class Unit {
    protected State state;

    public Unit(State state) {
        this.state = state;
    }

    public void addMacro(String macroName, MacroAction macro) {
        state.addMacro(macroName, macro);
    }

    public void performAction(String actionName) {
        state.performAction(actionName);
    }

    public void info() {
        state.printMetrics();
    }
}
