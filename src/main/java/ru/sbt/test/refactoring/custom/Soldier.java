package ru.sbt.test.refactoring.custom;

import ru.sbt.test.refactoring.custom.feature.ActionCounter;
import ru.sbt.test.refactoring.custom.feature.Field;
import ru.sbt.test.refactoring.custom.feature.SoldierInDitchException;
import ru.sbt.test.refactoring.metrics.ammo.Ammo;
import ru.sbt.test.refactoring.stdlib.unit.ShootingMovableUnit;

/**
 * Created by Maxim on 12/7/2015.
 */
public class Soldier extends ShootingMovableUnit {
    private Field field = new Field(5, 5);
    private ActionCounter actionCounter = new ActionCounter();

    public Soldier(Ammo ammo) {
        super(ammo);
    }

    @Override
    public void performAction(String actionName) {
        super.performAction(actionName);
        if (field.out(getX(), getY()))
            throw new SoldierInDitchException();
        actionCounter.count(actionName);
    }

    public void summary() {
        actionCounter.summary();
    }
}
