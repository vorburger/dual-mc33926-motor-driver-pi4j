package ch.vorburger.raspberry.mc33926;

import java.util.ArrayList;
import java.util.List;

import ch.vorburger.raspberry.motors.LoggingMotor;

class TestMotor extends LoggingMotor {

	List<Integer> setSpeeds = new ArrayList<>();

	public TestMotor() {
		super("test");
	}

	@Override
	public void setSpeed(int speed) {
		setSpeeds.add(speed);
		super.setSpeed(speed);
	}

}