package ch.vorburger.raspberry.turtle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch.vorburger.raspberry.motors.TwoMotors;

public class AsyncTurtle extends Turtle {

	protected final ExecutorService executor = Executors.newSingleThreadExecutor();

	public AsyncTurtle(TwoMotors motors) {
		super(motors);
	}

	public AsyncTurtle(TwoMotors motors, double turnDegreeSleep) {
		super(motors, turnDegreeSleep);
	}

	@Override
	protected synchronized void unidirectional(double seconds, int speed) {
		executor.submit(() -> super.unidirectional(seconds, speed));
	}

	@Override
	protected synchronized void turn(int degrees, boolean direction) {
		executor.submit(() -> super.turn(degrees, direction));
	}

	@Override
	public void halt() {
		super.halt();
		executor.shutdownNow();
	}
}
