package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.motors.TwoMotors;

public class AsyncTurtle extends Turtle {

	protected Thread asyncStopThread;

	public AsyncTurtle(TwoMotors motors) {
		super(motors);
	}

	@Override
	protected synchronized void haltInSeconds(double seconds) {
		interruptAsyncStopThread();
		asyncStopThread = new Thread((Runnable) () -> {
			// super.haltInSeconds(seconds);
			try {
				Thread.sleep((long) (seconds * 1000));
				if (asyncStopThread != null && !asyncStopThread.isInterrupted() && asyncStopThread.isAlive()) {
					halt();
				}
			} catch (InterruptedException e) {
				// Do nothing.  (Don't stop; see AsyncTurtle & AsyncTurtleTest for why.)
			}
		}, "AsyncTurtle.halt()");
		asyncStopThread.start();
	}

	@Override
	public synchronized void halt() {
		super.halt();
		interruptAsyncStopThread();
	}

	private void interruptAsyncStopThread() {
		if (asyncStopThread != null) {
			asyncStopThread.interrupt();
			asyncStopThread = null;
		}
	}

}
