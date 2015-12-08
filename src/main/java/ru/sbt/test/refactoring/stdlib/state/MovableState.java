package ru.sbt.test.refactoring.stdlib.state;

import ru.sbt.test.refactoring.ability.movement.NorthBehavior;
import ru.sbt.test.refactoring.ability.movement.PositionChangeListener;
import ru.sbt.test.refactoring.metrics.position.Coordinates;
import ru.sbt.test.refactoring.metrics.position.Orientation;
import ru.sbt.test.refactoring.metrics.position.Position;
import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.state.behavior.Action;
import ru.sbt.test.refactoring.state.behavior.Behavior;

import java.util.HashMap;

/**
 * Created by Maxim on 12/6/2015.
 */
public class MovableState extends State implements PositionChangeListener {
    private Position position;

    public MovableState() {
        Coordinates initialCoordinates = new Coordinates(0, 0);
        position = new Position(initialCoordinates, Orientation.NORTH);
        behavior = new NorthBehavior();
    }

    @Override
    public void changeBehavior(HashMap<String, Action> actions) {
        for (String actionName : actions.keySet()) {
            behavior.addAction(actionName, actions.get(actionName));
        }
    }

    @Override
    public void onCoordinatesChanged(Coordinates newCoordinates) {
        position = new Position(newCoordinates, position.getOrientation());
    }

    @Override
    public void onOrientationChanged(Orientation newOrientation) {
        position = new Position(position.getCoordinates(), newOrientation);
    }

    @Override
    public int getX() {
        return position.getCoordinates().getX();
    }

    @Override
    public int getY() {
        return position.getCoordinates().getY();
    }

    @Override
    public void printMetrics() {
        System.out.format("Coordinates: (%d,%d)\nOrientation: %s\n", getX(), getY(), position.getOrientation());
    }

    public Orientation getOrientation() {
        return position.getOrientation();
    }
}
