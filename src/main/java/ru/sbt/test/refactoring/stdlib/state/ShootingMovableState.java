package ru.sbt.test.refactoring.stdlib.state;

import ru.sbt.test.refactoring.ability.shooting.LoadedBehavior;
import ru.sbt.test.refactoring.ability.shooting.ShotListener;
import ru.sbt.test.refactoring.metrics.ammo.Ammo;
import ru.sbt.test.refactoring.state.behavior.Action;

import java.util.HashMap;

/**
 * Created by Maxim on 12/7/2015.
 */
public class ShootingMovableState extends MovableState implements ShotListener {
    Ammo ammo;

    public ShootingMovableState(Ammo ammo) {
        super();
        this.ammo = ammo;
        changeBehavior(LoadedBehavior.getLoadedBehavior());
    }

    @Override
    public void changeBehavior(HashMap<String, Action> actions) {
        for (String action : actions.keySet()) {
            behavior.addAction(action, actions.get(action));
        }
    }

    @Override
    public void onReload() {
        ammo.reload();
    }

    @Override
    public void onShoot() {
        ammo.shoot();
    }

    @Override
    public int getCurrentStripperClip() {
        return ammo.getCurrentStripperClip();
    }

    @Override
    public int getAmount() {
        return ammo.getAmount();
    }

    @Override
    public void printMetrics() {
        super.printMetrics();
        System.out.format("Ammo: %d/%d\n", getCurrentStripperClip(), getAmount());
    }
}
