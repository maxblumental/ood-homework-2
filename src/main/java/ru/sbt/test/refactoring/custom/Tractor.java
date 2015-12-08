package ru.sbt.test.refactoring.custom;

import ru.sbt.test.refactoring.custom.feature.ActionCounter;
import ru.sbt.test.refactoring.custom.feature.Field;
import ru.sbt.test.refactoring.custom.feature.TractorInDitchException;
import ru.sbt.test.refactoring.stdlib.state.MovableState;

public class Tractor extends MovableState {
	private Field field = new Field(5, 5);
	private ActionCounter actionCounter = new ActionCounter();

	@Override
	public void performAction(String actionName) {
		super.performAction(actionName);
		if (field.out(getX(), getY()))
			throw new TractorInDitchException();
		actionCounter.count(actionName);
	}

	public void summary() {
		actionCounter.summary();
	}
}
