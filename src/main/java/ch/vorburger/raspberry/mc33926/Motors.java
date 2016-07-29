package ch.vorburger.raspberry.mc33926;

import com.pi4j.io.gpio.RaspiPin;

public class Motors {

	public final Motor motor1 = new Motor(RaspiPin.GPIO_12, RaspiPin.GPIO_24, RaspiPin.GPIO_22);
	public final Motor motor2 = new Motor(RaspiPin.GPIO_13, RaspiPin.GPIO_25, RaspiPin.GPIO_23);

	public void enable() {
		motor1.enable();
		motor2.enable();
	}

	public void disable() {
		motor1.disable();
		motor2.disable();
	}

	public void setSpeeds(int motor1Speed, int motor2Speed) {
		motor1.setSpeed(motor1Speed);
		motor2.setSpeed(motor2Speed);
	}

}
