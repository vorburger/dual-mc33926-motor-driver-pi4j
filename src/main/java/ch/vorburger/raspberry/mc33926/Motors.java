package ch.vorburger.raspberry.mc33926;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;

import ch.vorburger.raspberry.motors.ReverseMotor;

public class Motors {

	static {
		GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
	}
	
	public final Motor motor1 = new Motor(RaspiBcmPin.GPIO_12, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_22);
	public final Motor motor2 = new ReverseMotor(RaspiBcmPin.GPIO_13, RaspiBcmPin.GPIO_25, RaspiBcmPin.GPIO_23);

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
