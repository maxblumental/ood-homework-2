package ru.sbt.test.refactoring.ability.shooting;

import ru.sbt.test.refactoring.state.State;
import ru.sbt.test.refactoring.state.behavior.Action;
import ru.sbt.test.refactoring.state.behavior.Behavior;
import ru.sbt.test.refactoring.state.behavior.MacroAction;

import java.util.HashMap;

/**
 * Created by Maxim on 12/7/2015.
 */
public class LoadedBehavior extends Behavior {
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
                        ShotListener listener;
                        try {
                            listener = (ShotListener) state;
                        } catch (ClassCastException e) {
                            return;
                        }
                        listener.onShoot();
                        System.out.format("%s: bang-bang!!!\n", this.SHOOT.toString());
                        if (listener.getCurrentStripperClip() == 0) {
                            listener.changeBehavior(EmptyBehavior.getEmptyBehavior());
                        }
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
                    };
            }

            return null;
        }
    }

    public static HashMap<String, Action> getLoadedBehavior() {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put(Shooting.RELOAD.toString(), Shooting.RELOAD.getAction());
        actions.put(Shooting.SHOOT.toString(), Shooting.SHOOT.getAction());
        return actions;
    }
}
