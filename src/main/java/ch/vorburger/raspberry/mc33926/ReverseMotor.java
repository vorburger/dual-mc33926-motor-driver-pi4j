package ch.vorburger.raspberry.mc33926;

import com.pi4j.io.gpio.Pin;

public class ReverseMotor extends Motor {

	public ReverseMotor(Pin pwmPin, Pin directionPin, Pin enablePin) {
		super(pwmPin, directionPin, enablePin);
	}

	@Override
	public void setSpeed(int speed) {
		super.setSpeed( -speed);
	}
}
