package ch.vorburger.raspberry.motors;

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
