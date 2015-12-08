package ru.sbt.test.refactoring.custom;

import ru.sbt.test.refactoring.ability.movement.Movements;
import ru.sbt.test.refactoring.ability.shooting.Shooting;
import ru.sbt.test.refactoring.custom.feature.SoldierInDitchException;
import ru.sbt.test.refactoring.custom.feature.TractorInDitchException;
import ru.sbt.test.refactoring.metrics.ammo.Ammo;
import ru.sbt.test.refactoring.state.behavior.MacroAction;

/**
 * Created by Maxim on 12/7/2015.
 */
public class RunClass {
    public static void main(String[] args) {
        Tractor tractor = new Tractor();
        Soldier soldier = new Soldier(new Ammo(24, 6));
        try {
            /*We have a tractor who's able to move.*/
            tractor.performAction(Movements.MOVE_FORWARD.toString());
            tractor.performAction(Movements.TURN_CLOCKWISE.toString());

            /*And a soldier who can also shoot.*/
            soldier.performAction(Shooting.SHOOT.toString());
            soldier.performAction(Shooting.RELOAD.toString());
            soldier.performAction(Movements.MOVE_FORWARD.toString());
            soldier.performAction(Movements.TURN_CLOCKWISE.toString());

            /*Users can create custom macros at runtime...*/
            String TURN_AND_SHOOT = "turn and shoot";
            MacroAction macro = new MacroAction();
            macro.addAction(Movements.TURN_CLOCKWISE.toString());
            macro.addAction(Shooting.SHOOT.toString());
            soldier.addMacro(TURN_AND_SHOOT, macro);

            /*...and use it right away.*/
            soldier.performAction(TURN_AND_SHOOT);
        } catch (SoldierInDitchException e) {
            System.out.println("Soldier is out");
        } catch (TractorInDitchException e) {
            System.out.println("Tractor is out");
        } finally {
            /* At the end of the game the users
             * can learn action statistics.
             */
            soldier.summary();
            tractor.summary();
        }
    }
}
