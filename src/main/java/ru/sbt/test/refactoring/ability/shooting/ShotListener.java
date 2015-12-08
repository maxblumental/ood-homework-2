package ru.sbt.test.refactoring.ability.shooting;

import ru.sbt.test.refactoring.state.behavior.Action;

import java.util.HashMap;

/**
 * Created by Maxim on 12/7/2015.
 */
public interface ShotListener {
    void changeBehavior(HashMap<String, Action> actions);
    void onReload();
    void onShoot();
    int getCurrentStripperClip();
    int getAmount();
}
