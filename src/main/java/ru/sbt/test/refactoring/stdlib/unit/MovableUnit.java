package ru.sbt.test.refactoring.stdlib.unit;

import ru.sbt.test.refactoring.metrics.position.Orientation;
import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.stdlib.state.MovableState;
import ru.sbt.test.refactoring.unit.Unit;

/**
 * Created by Maxim on 12/8/2015.
 */
public class MovableUnit extends Unit {
    public MovableUnit() {
        super(new MovableState());
    }

    protected MovableUnit(MovableState state) {
        super(state);
    }

    public int getX() {
        return ((MovableState) state).getX();
    }

    public int getY() {
        return ((MovableState) state).getY();
    }

    public Orientation getOrientation() {
        return ((MovableState) state).getOrientation();
    }
}
