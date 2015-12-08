package ru.sbt.test.refactoring.metrics.position;

/**
 * Created by Maxim on 12/6/2015.
 */
public class Coordinates {
    private final int X;
    private final int Y;

    public Coordinates(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
