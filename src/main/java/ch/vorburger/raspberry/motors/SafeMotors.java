package ch.vorburger.raspberry.motors;

import ch.vorburger.raspberry.mc33926.TwoMotors;

public class SafeMotors {

	static public void move(TwoMotors motors, SafeMotorsRunnable runnable) {
		motors.setSpeeds(0, 0);
		try {
			runnable.run(motors);
		} finally {
			motors.setSpeeds(0, 0);
			motors.disable();
		};
	}

}
