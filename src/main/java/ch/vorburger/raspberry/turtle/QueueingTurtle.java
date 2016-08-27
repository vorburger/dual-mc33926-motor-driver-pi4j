package ch.vorburger.raspberry.turtle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch.vorburger.raspberry.motors.TwoMotors;

public class QueueingTurtle extends Turtle {

	protected ExecutorService executor = getNewExecutorService();

	public QueueingTurtle(TwoMotors motors) {
		super(motors);
	}

	public QueueingTurtle(TwoMotors motors, double turnDegreeSleep) {
		super(motors, turnDegreeSleep);
	}

	@Override
	protected synchronized void unidirectional(double seconds, int speed) {
		getExecutorService().submit(() -> super.unidirectional(seconds, speed));
	}

	@Override
	protected synchronized void turn(int degrees, boolean direction) {
		getExecutorService().submit(() -> super.turn(degrees, direction));
	}

	private ExecutorService getNewExecutorService() {
		return Executors.newSingleThreadExecutor();
	}

	private ExecutorService getExecutorService() {
		if (executor.isShutdown()) {
			executor = getNewExecutorService();
		}
		return executor;
	}

	@Override
	public void halt() {
		super.halt();
		executor.shutdownNow();
		super.halt();
	}
}
