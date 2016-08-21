package ch.vorburger.raspberry.turtle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch.vorburger.raspberry.mc33926.Motors;

public class AsyncTurtle extends Turtle {

	protected final ExecutorService executor = Executors.newSingleThreadExecutor();

	public AsyncTurtle(Motors motors) {
		super(motors);
	}

	public AsyncTurtle(Motors motors, double turnDegreeSleep) {
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

	public void stop() {
		executor.shutdownNow();
	}
}
