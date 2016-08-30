package ch.vorburger.raspberry.mc33926;

import javax.inject.Provider;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;

import ch.vorburger.raspberry.motors.LoggingMotor;
import ch.vorburger.raspberry.motors.Motor;
import ch.vorburger.raspberry.motors.ReverseMotor;
import ch.vorburger.raspberry.motors.TwoMotors;

public class TwoMotorsProvider implements Provider<TwoMotors> {

	static private boolean gpioFactoryDefaultProviderInitialized = false;

	@Override
	public TwoMotors get() {
		if (!Boolean.getBoolean("fakeMotors")) {
			initializeGpioFactoryDefaultProvider();
			Motor motor1 = new GpioMotor(RaspiBcmPin.GPIO_12, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_22);
			Motor motor2 = new ReverseMotor(new GpioMotor(RaspiBcmPin.GPIO_13, RaspiBcmPin.GPIO_25, RaspiBcmPin.GPIO_23));
			return new TwoMotors(motor1, motor2);
		} else {
			return new TwoMotors(new LoggingMotor("left"), new LoggingMotor("right"));
		}
	}

	private void initializeGpioFactoryDefaultProvider() {
		if (!gpioFactoryDefaultProviderInitialized) {
			GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
			gpioFactoryDefaultProviderInitialized = true;
		}
	}

}
