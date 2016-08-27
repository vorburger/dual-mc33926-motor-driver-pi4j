package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.mc33926.TwoMotors;
import ch.vorburger.raspberry.motors.SafeMotors;

public class SafeTurtle {

	static public void move(TwoMotors motors, SafeTurtleRunnable runnable) {
		SafeMotors.move(motors, _motors -> {
			runnable.run(new Turtle(_motors));
		});
	}

}
