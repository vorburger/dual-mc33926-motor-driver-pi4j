package ch.vorburger.raspberry.mc33926;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MotorTest {

	@Test
	public void stepTo() {
		TestMotor motor = new TestMotor();
		motor.stepTo(0, 3);
		assertEquals(Arrays.asList(0, 1, 2, 3), motor.setSpeeds);
	}

	@Test
	public void stepToAndInverse() {
		TestMotor motor = new TestMotor();
		motor.stepToAndInverse(0, 3);
		assertEquals(Arrays.asList(0, 1, 2, 3, 2, 1, 0), motor.setSpeeds);
	}

}
