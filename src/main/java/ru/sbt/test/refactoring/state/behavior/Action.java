package ru.sbt.test.refactoring.state.behavior;

import ru.sbt.test.refactoring.state.State;

/**
 * Created by Maxim on 12/6/2015.
 */
@FunctionalInterface
public interface Action {
    void perform(State state);
}
