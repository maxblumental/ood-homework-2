package ru.sbt.test.refactoring.metrics.position;

/**
 * Created by Maxim on 12/6/2015.
 */
public class Position {
    private final Coordinates coordinates;
    private final Orientation orientation;

    public Position(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
