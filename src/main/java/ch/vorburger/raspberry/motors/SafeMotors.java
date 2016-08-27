package ch.vorburger.raspberry.motors;

import ch.vorburger.raspberry.mc33926.TwoMotors;

public class SafeMotors {

	static public void move(TwoMotors motors, SafeMotorsRunnable runnable) {
		new SafeMotors(motors).run(runnable);
	}

	protected final TwoMotors motors;

	public SafeMotors(TwoMotors motors) {
		this.motors = motors;
	}

	public void start() {
		motors.enable();
		motors.setSpeeds(0, 0);
	}

	public void run(SafeMotorsRunnable runnable) {
		start();
		try {
			runnable.run(motors);
		} finally {
			stop();
		}
	}

	public void stop() {
		motors.setSpeeds(0, 0);
		motors.disable();
	}

}
