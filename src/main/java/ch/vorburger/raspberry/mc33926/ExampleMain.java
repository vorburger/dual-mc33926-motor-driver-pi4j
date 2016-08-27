package ch.vorburger.raspberry.mc33926;

import static ch.vorburger.raspberry.mc33926.Motor.MAX_SPEED;
import static ch.vorburger.raspberry.motors.SleepUtil.sleepSeconds;

import ch.vorburger.raspberry.turtle.SafeTurtle;
import ch.vorburger.raspberry.turtle.Turtle;

public class ExampleMain {

	public static void main(String[] args) throws Exception {
		// This is just to initially stop it.. handy if things went out of control! ;)
//		SafeMotors.move(motors -> { });
//		System.out.println("Hit Enter when ready for Rover to moving?");
//		System.console().readLine();

//		TurtleCalibration.main(args);

		SafeTurtle.move(turtle -> {
			triangle(turtle);
			dance(turtle);
		});
//		SafeMotors.move(motors -> {
//			motors(motors);
//		});
	}

	private static void triangle(Turtle turtle) {
		for (int i = 0; i < 3; i++) {
			turtle.forward(2);
			turtle.turnRight(120);
		}
	}

	private static void dance(Turtle turtle) {
		for (int i = 0; i < 3; i++) {
			turtle.backward(0.5);
			turtle.forward(0.5);
		}
	}

	private static void turtle2(Turtle turtle) {
		turtle.forward(6);
		turtle.turnLeft(45);
		turtle.forward(10);
		turtle.turnRight(90);
		turtle.forward(4);
		turtle.backward(2);
		turtle.forward(2);
		turtle.backward(2);
		turtle.forward(2);
	}

	private static void motors(TwoMotors motors) {
		print("Motor 1 forward");
		motors.motor1().stepToAndInverse(0, MAX_SPEED);

		print("Motor 1 reverse");
		motors.motor1().stepToAndInverse(0, -MAX_SPEED);

		print("Motor 2 forward");
		motors.motor2().stepToAndInverse(0, MAX_SPEED);

		print("Motor 2 reverse");
		motors.motor2().stepToAndInverse(0, -MAX_SPEED);

		print("Motor 1 & 2 forward");
		motors.setSpeeds(MAX_SPEED, MAX_SPEED);
		sleepSeconds(3);

		print("Motor 1 & 2 reverse");
		motors.setSpeeds(-MAX_SPEED, -MAX_SPEED);
		sleepSeconds(3);
	}

	private static void print(String message) {
		System.out.println(message);
	}

}
