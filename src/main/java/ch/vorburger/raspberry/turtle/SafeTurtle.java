package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.mc33926.TwoMotors;
import ch.vorburger.raspberry.motors.SafeMotors;

public class SafeTurtle {

	static public void move(TwoMotors motors2, SafeTurtleRunnable runnable) {
		SafeMotors.move(motors2, motors -> {
			runnable.run(new Turtle(motors));
		});
	}

}
