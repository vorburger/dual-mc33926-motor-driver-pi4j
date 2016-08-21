package ch.vorburger.raspberry.motors;

import static ch.vorburger.raspberry.motors.SleepUtil.sleepSeconds;

public abstract class AbstractMotor {

	protected abstract void setSpeed(int speed);

	public void stepToAndInverse(int start, int end) {
		stepTo(start, end);
		stepTo(end - 1, start);
	}
	
	public void stepTo(int start, int end) {
		if (end > start) {
			for (int s = start; s <= end; s++) {
				setSpeed(s);
				sleepSeconds(0.005);
			}
		} else {
			for (int s = start; s >= end; s--) {
				setSpeed(s);
				sleepSeconds(0.005);
			}			
		}
	}
	
}
