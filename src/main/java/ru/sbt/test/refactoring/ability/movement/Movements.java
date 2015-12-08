package ru.sbt.test.refactoring.ability.movement;

/**
 * Created by Maxim on 12/6/2015.
 */
public enum Movements {
    MOVE_FORWARD("move forward"),
    TURN_CLOCKWISE("turn clockwise");

    Movements(String text) {
        this.text = text;
    }

    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
