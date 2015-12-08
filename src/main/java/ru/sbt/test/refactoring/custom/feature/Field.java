package ru.sbt.test.refactoring.custom.feature;

/**
 * Created by Maxim on 12/8/2015.
 */
public class Field {
    private final int width;
    private final int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean out(int x, int y) {
        if (x > width || x < -width || y > height || y < -height)
            return true;
        return false;
    }
}
