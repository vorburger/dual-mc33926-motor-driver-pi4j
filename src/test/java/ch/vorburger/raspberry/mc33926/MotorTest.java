package ch.vorburger.raspberry.mc33926;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ch.vorburger.raspberry.motors.Motor;

public class MotorTest {

	private static class TestMotor extends Motor {

		List<Integer> setSpeeds = new ArrayList<>();

		@Override
		public void setSpeed(int speed) {
			setSpeeds.add(speed);
		}

		@Override
		public void enable() {
		}

		@Override
		public void disable() {
		}

	}

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
