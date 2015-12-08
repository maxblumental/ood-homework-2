package ru.sbt.test.refactoring.stdlib.unit;

import ru.sbt.test.refactoring.metrics.ammo.Ammo;
import ru.sbt.test.refactoring.stdlib.state.ShootingMovableState;

/**
 * Created by Maxim on 12/8/2015.
 */
public class ShootingMovableUnit extends MovableUnit {
    public ShootingMovableUnit(Ammo ammo) {
        super(new ShootingMovableState(ammo));
    }

    public int getCurrentStripperyClip() {
        return ((ShootingMovableState) state).getCurrentStripperClip();
    }

    public int getAmmoAmount() {
        return ((ShootingMovableState) state).getAmount();
    }
}
