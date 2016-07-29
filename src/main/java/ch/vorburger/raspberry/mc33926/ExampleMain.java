package ch.vorburger.raspberry.mc33926;

import static ch.vorburger.raspberry.mc33926.Motor.MAX_SPEED;

public class ExampleMain {

	public static void main(String[] args) throws Exception {
		Motors motors = new Motors();
		try {
			motors.enable();
			motors.setSpeeds(0, 0);
			
			print("Motor 1 forward");
			motors.motor1.stepToAndInverse(0, MAX_SPEED);
			
			print("Motor 1 reverse");
			motors.motor1.stepToAndInverse(0, -MAX_SPEED);
			
			print("Motor 2 forward");
			motors.motor2.stepToAndInverse(0, MAX_SPEED);
			
			print("Motor 2 reverse");
			motors.motor2.stepToAndInverse(0, -MAX_SPEED);
			
		} finally {
			motors.setSpeeds(0, 0);
			motors.disable();
		}
	}

	private static void print(String message) {
		System.out.println(message);
	}

}
