package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.mc33926.GpioMotor;
import ch.vorburger.raspberry.motors.TwoMotors;

public class Turtle {

	private final TwoMotors motors;
	private final double turnDegreeSleepFactor;

	private int speed = GpioMotor.MAX_SPEED;

	public Turtle(TwoMotors motors, double turnDegreeSleep) {
		this.motors = motors;
		this.turnDegreeSleepFactor = turnDegreeSleep;
	}

	public Turtle(TwoMotors motors) {
		this(motors, 0.021284722222222222); // see TurtleCalibration
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public synchronized void halt() {
		motors.setSpeeds(0, 0);
	}

	public synchronized void forward(double seconds) {
		unidirectional(seconds, speed);
	}

	public synchronized void backward(double seconds) {
		unidirectional(seconds, -speed);
	}

	public synchronized void turnRight(int degrees) {
		turn(degrees, true);
	}

	public synchronized void turnLeft(int degrees) {
		turn(-degrees, false);
	}

	protected synchronized void unidirectional(double seconds, int speed) {
		motors.setSpeeds(speed, speed);
		haltInSeconds(seconds);
	}

	protected synchronized void turn(int degrees, boolean direction) {
		if (direction)
			motors.setSpeeds(speed, -speed);
		else
			motors.setSpeeds(-speed, speed);
		haltInSeconds(turnDegreeSleepFactor * Math.abs(degrees));
	}

	protected synchronized void haltInSeconds(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
			halt();
		} catch (InterruptedException e) {
			// Do nothing.  (Don't stop; see AsyncTurtle & AsyncTurtleTest for why.)
		}
	}

}
