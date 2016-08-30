package ch.vorburger.raspberry.mc33926;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ch.vorburger.raspberry.motors.TwoMotors;
import ch.vorburger.raspberry.turtle.AsyncTurtle;

public class AsyncTurtleTest {

	@Test
	public void asyncStop1() throws Exception {
		TestMotor leftTestMotor = new TestMotor();
		TestMotor rightTestMotor = new TestMotor();
		TwoMotors motors = new TwoMotors(leftTestMotor, rightTestMotor);
		AsyncTurtle turtle = new AsyncTurtle(motors);
		turtle.forward(0.2);
		turtle.forward(0.2);
		Thread.sleep(500);
		assertEquals(Arrays.asList(480, 480, 0), leftTestMotor.setSpeeds);
		assertEquals(Arrays.asList(480, 480, 0), rightTestMotor.setSpeeds);
	}

	@Test
	public void asyncStop2() throws Exception {
	    for (int i = 0; i < 100; i++) {
			TestMotor leftTestMotor = new TestMotor();
			TestMotor rightTestMotor = new TestMotor();
			TwoMotors motors = new TwoMotors(leftTestMotor, rightTestMotor);
			AsyncTurtle turtle = new AsyncTurtle(motors);
			turtle.forward(0.1);
			turtle.forward(0.1);
			turtle.forward(0.1);
			Thread.sleep(250);
			assertEquals(Arrays.asList(480, 480, 480, 0), leftTestMotor.setSpeeds);
			assertEquals(Arrays.asList(480, 480, 480, 0), rightTestMotor.setSpeeds);
	    }
	}
}
