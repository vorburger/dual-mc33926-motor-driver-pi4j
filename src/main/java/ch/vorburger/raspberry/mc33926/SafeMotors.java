package ch.vorburger.raspberry.mc33926;

public class SafeMotors {

	static public void move(SafeMotorsRunnable runnable) {
		new SafeMotors().run(runnable);
	}

	protected final Motors motors;

	public SafeMotors() {
		motors = new Motors();
	}

	public SafeMotors(Motors motors) {
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
