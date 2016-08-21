package ch.vorburger.raspberry.mc33926.turtle;

import ch.vorburger.raspberry.mc33926.SafeMotors;

public class SafeTurtle {

	static public void move(SafeTurtleRunnable runnable) {
		SafeMotors.move(motors -> {
			runnable.run(new Turtle(motors));
		});
	}

}
