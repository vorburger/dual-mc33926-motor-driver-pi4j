package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.motors.SafeMotors;

public class SafeTurtle {

	static public void move(SafeTurtleRunnable runnable) {
		SafeMotors.move(motors -> {
			runnable.run(new Turtle(motors));
		});
	}

}
