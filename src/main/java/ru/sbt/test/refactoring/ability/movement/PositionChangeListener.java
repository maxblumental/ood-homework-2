package ru.sbt.test.refactoring.ability.movement;

import ru.sbt.test.refactoring.metrics.position.Coordinates;
import ru.sbt.test.refactoring.metrics.position.Orientation;
import ru.sbt.test.refactoring.state.behavior.Action;
import ru.sbt.test.refactoring.state.behavior.Behavior;

import java.util.HashMap;

/**
 * Created by Maxim on 12/6/2015.
 */
public interface PositionChangeListener {
    void changeBehavior(HashMap<String, Action> actions);
    void onCoordinatesChanged(Coordinates newCoordinates);
    void onOrientationChanged(Orientation newOrientation);
    int getX();
    int getY();
}
