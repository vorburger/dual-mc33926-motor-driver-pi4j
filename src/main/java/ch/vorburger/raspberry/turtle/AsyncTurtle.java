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
		asyncStopThread = new Thread((Runnable) () -> super.haltInSeconds(seconds), "AsyncTurtle.halt()");
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
