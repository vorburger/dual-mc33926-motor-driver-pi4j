package ch.vorburger.raspberry.mc33926;

import javax.inject.Provider;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;

import ch.vorburger.raspberry.motors.ReverseMotor;

public class TwoMotorsProvider implements Provider<TwoMotors> {

	static {
		GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
	}

	@Override
	public TwoMotors get() {
		Motor motor1 = new Motor(RaspiBcmPin.GPIO_12, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_22);
		Motor motor2 = new ReverseMotor(RaspiBcmPin.GPIO_13, RaspiBcmPin.GPIO_25, RaspiBcmPin.GPIO_23);
		return new TwoMotors(motor1, motor2);
	}

}
