package ru.sbt.test.refactoring.ability.shooting;

import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.state.behavior.Action;
import ru.sbt.test.refactoring.state.behavior.Behavior;
import ru.sbt.test.refactoring.state.behavior.MacroAction;

import java.util.HashMap;

/**
 * Created by Maxim on 12/7/2015.
 */
public class EmptyBehavior extends Behavior {
    private enum Shooting {
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

        public Action getAction() {
            switch (this) {
                case SHOOT:
                    return ((State state) -> {
                        System.out.format("%s: click-click...\n", this.SHOOT.toString());
                    });
                case RELOAD:
                    return (State state) -> {
                        ShotListener listener;
                        try {
                            listener = (ShotListener) state;
                        } catch (ClassCastException e) {
                            return;
                        }
                        listener.onReload();
                        System.out.format("%s: %d/%d\n", this.RELOAD.toString(),
                                listener.getCurrentStripperClip(), listener.getAmount());
                        if (listener.getCurrentStripperClip() > 0) {
                            listener.changeBehavior(LoadedBehavior.getLoadedBehavior());
                        }
                    };
            }

            return null;
        }
    }

    public static HashMap<String, Action> getEmptyBehavior() {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put(Shooting.RELOAD.toString(), Shooting.RELOAD.getAction());
        actions.put(Shooting.SHOOT.toString(), Shooting.SHOOT.getAction());
        return actions;
    }
}

