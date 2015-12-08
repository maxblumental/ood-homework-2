package ru.sbt.test.refactoring.ability.shooting;

/**
 * Created by Maxim on 12/7/2015.
 */
public enum Shooting {
    SHOOT("shoot"),
    RELOAD("reload");

    Shooting(String text) {
        this.text = text;
    }

    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
