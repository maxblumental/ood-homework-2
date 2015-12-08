package ru.sbt.test.refactoring.ability.movement;

import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.state.behavior.Action;
import ru.sbt.test.refactoring.state.behavior.Behavior;
import ru.sbt.test.refactoring.metrics.position.Coordinates;
import ru.sbt.test.refactoring.metrics.position.Orientation;

import java.util.HashMap;

/**
 * Created by Maxim on 12/6/2015.
 */
public class SouthBehavior extends Behavior {
    public SouthBehavior() {
        super();
        addAction(Movements.MOVE_FORWARD.toString(), Movements.MOVE_FORWARD.getAction());
        addAction(Movements.TURN_CLOCKWISE.toString(), Movements.TURN_CLOCKWISE.getAction());
    }

    private enum Movements {
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

        public Action getAction() {
            switch (this) {
                case MOVE_FORWARD:
                    return ((State state) -> {
                        PositionChangeListener listener;
                        try {
                            listener = (PositionChangeListener) state;
                        } catch (ClassCastException e) {
                            return;
                        }
                        int x = listener.getX(), y = listener.getY();
                        listener.onCoordinatesChanged(new Coordinates(x, y - 1));
                        System.out.format("%s: (%d,%d)->(%d,%d)\n", this, x, y, x, y - 1);
                    });
                case TURN_CLOCKWISE:
                    return (State state) -> {
                        PositionChangeListener listener;
                        try {
                            listener = (PositionChangeListener) state;
                        } catch (ClassCastException e) {
                            return;
                        }
                        listener.onOrientationChanged(Orientation.WEST);
                        listener.changeBehavior(WestBehavior.getWestBehavior());
                        System.out.format("%s: %s->%s\n", this, Orientation.SOUTH, Orientation.WEST);
                    };
            }

            return null;
        }
    }

    public static HashMap<String, Action> getSouthBehavior() {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put(Movements.MOVE_FORWARD.toString(), Movements.MOVE_FORWARD.getAction());
        actions.put(Movements.TURN_CLOCKWISE.toString(), Movements.TURN_CLOCKWISE.getAction());
        return actions;
    }
}
