package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.motors.SafeMotors;
import ch.vorburger.raspberry.motors.TwoMotors;

public class SafeTurtle {

	static public void move(TwoMotors motors, SafeTurtleRunnable runnable) {
		SafeMotors.move(motors, _motors -> {
			runnable.run(new Turtle(_motors));
		});
	}

}
