package ch.vorburger.raspberry.motors;

import ch.vorburger.raspberry.mc33926.Motors;

@FunctionalInterface
public interface SafeMotorsRunnable {

	void run(Motors motors);

}
