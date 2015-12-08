package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.ability.movement.Movements;
import ru.sbt.test.refactoring.custom.Tractor;
import ru.sbt.test.refactoring.custom.feature.TractorInDitchException;
import ru.sbt.test.refactoring.metrics.position.Orientation;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

	public void testShouldMoveForward(){
		Tractor tractor = new Tractor();
		tractor.performAction(Movements.MOVE_FORWARD.toString());
		assertEquals(0, tractor.getX());
		assertEquals(1, tractor.getY());
	}

	public void testShouldTurn(){
		Tractor tractor = new Tractor();

        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
		assertEquals(Orientation.EAST, tractor.getOrientation());

        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
		assertEquals(Orientation.SOUTH, tractor.getOrientation());

        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
		assertEquals(Orientation.WEST, tractor.getOrientation());

        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
		assertEquals(Orientation.NORTH, tractor.getOrientation());
	}

	public void testShouldTurnAndMoveInTheRightDirection(){
		Tractor tractor = new Tractor();
        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
		assertEquals(1, tractor.getX());
		assertEquals(0, tractor.getY());
        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        assertEquals(1, tractor.getX());
		assertEquals(-1, tractor.getY());
        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        assertEquals(0, tractor.getX());
		assertEquals(-1, tractor.getY());
        tractor.performAction(Movements.TURN_CLOCKWISE.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        assertEquals(0, tractor.getX());
		assertEquals(0, tractor.getY());
	}

	public void testShouldThrowExceptionIfFallsOffPlateau(){
		Tractor tractor = new Tractor();
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
        tractor.performAction(Movements.MOVE_FORWARD.toString());
		try{
            tractor.performAction(Movements.MOVE_FORWARD.toString());
			fail("Tractor was expected to fall off the plateau");
		}catch(TractorInDitchException expected){
		}
	}
}
