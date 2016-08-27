package ch.vorburger.raspberry.motors;

@FunctionalInterface
public interface SafeMotorsRunnable {

	void run(TwoMotors motors);

}
