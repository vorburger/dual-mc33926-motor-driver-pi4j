package ch.vorburger.raspberry.mc33926;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMotor {
	private static final Logger LOG = LoggerFactory.getLogger(Motor.class);

	protected abstract void setSpeed(int speed);

	public void stepToAndInverse(int start, int end) {
		stepTo(start, end);
		stepTo(end - 1, start);
	}
	
	public void stepTo(int start, int end) {
		if (end > start) {
			for (int s = start; s <= end; s++) {
				setSpeed(s);
				sleep(0.005);
			}			
		} else {
			for (int s = start; s >= end; s--) {
				setSpeed(s);
				sleep(0.005);
			}			
		}
	}
	
	private void sleep(double second) {
		try {
			Thread.sleep((long) (second * 1000));
		} catch (InterruptedException e) {
			LOG.warn("sleep() InterruptedException", e);
		}

	}

}
