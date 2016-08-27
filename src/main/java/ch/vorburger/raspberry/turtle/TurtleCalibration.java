package ch.vorburger.raspberry.turtle;

import ch.vorburger.raspberry.mc33926.TwoMotors;
import ch.vorburger.raspberry.mc33926.TwoMotorsProvider;
import ch.vorburger.raspberry.motors.SafeMotors;

public class TurtleCalibration {

	public static void main(String[] args) throws Exception {
		System.out.println("Please watch how long it will take the Rover Turtle to turn around its axis twice... "
				+ "hit Enter when ready to start, and Enter again exactly when it has turned around 720° ...");
		System.console().readLine();
		TwoMotors motors = new TwoMotorsProvider().get();
		AsyncTurtle asyncTurtle = new AsyncTurtle(motors);
		long time = System.currentTimeMillis();
		asyncTurtle.turnRight(2000); // intentionally too large
		System.console().readLine();
		time = System.currentTimeMillis() - time;
		asyncTurtle.stop();

		double turnDegreeSleepSeconds = ((double) time)/1000 / 720;
		System.out.println("OK so the calculated calibration parameter for the Turtle constructor is: " + turnDegreeSleepSeconds);

		System.out.println("Let's try now - I'm going to run in what should be a perfect square... hit Enter when ready?");
		System.console().readLine();
		new SafeMotors(motors).run(_motors -> {
			Turtle calibratedTurtle = new Turtle(_motors, turnDegreeSleepSeconds);
			for (int i = 0; i < 4; i++) {
				calibratedTurtle.forward(2);
				calibratedTurtle.turnRight(90);
			}
		});

	}

}
