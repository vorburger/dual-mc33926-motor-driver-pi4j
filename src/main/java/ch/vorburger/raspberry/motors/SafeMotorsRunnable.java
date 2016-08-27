package ch.vorburger.raspberry.motors;

import ch.vorburger.raspberry.mc33926.TwoMotors;

@FunctionalInterface
public interface SafeMotorsRunnable {

	void run(TwoMotors motors);

}
