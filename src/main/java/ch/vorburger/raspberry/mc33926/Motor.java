package ch.vorburger.raspberry.mc33926;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public class Motor extends AbstractMotor {
	// private static final Logger LOG = LoggerFactory.getLogger(Motor.class);
	
	/**
	 * Motor speeds for this library are specified as numbers between -MAX_SPEED and MAX_SPEED, inclusive.
	 */
	public static final int MAX_SPEED = 480; // 19.2 MHz / 2 / 480 = 20 kHz	

	// private static wiringPiInitialized = false;
	
	private GpioPinPwmOutput pwmGpioPin;
	private GpioPinDigitalOutput directionGpioPin;
	private GpioPinDigitalOutput enableGpioPin;

	private boolean enabled = false;

	public Motor(Pin pwmPin, Pin directionPin, Pin enablePin) {
		GpioController gpio = GpioFactory.getInstance();
		
		// provisionSoftPwmOutputPin VS provisionPwmOutputPin ?
		pwmGpioPin = gpio.provisionPwmOutputPin(pwmPin, "pwm", 0);
		pwmGpioPin.setPwmRange(MAX_SPEED);
		// ? wiringpi.pwmSetMode(wiringpi.GPIO.PWM_MODE_MS)
		// ? wiringpi.pwmSetClock(2)
		
		directionGpioPin = gpio.provisionDigitalOutputPin(directionPin, "direction");
		enableGpioPin = gpio.provisionDigitalOutputPin(enablePin, "enable", PinState.LOW);
		
		// ? pwm/direction/enable/GpioPin.setShutdownOptions(...);
	}

	public void enable() {
		enabled = true;
		enableGpioPin.setState(PinState.HIGH);
	}

	public void disable() {
		enabled = false;
		enableGpioPin.setState(PinState.LOW);
	}

	public void setSpeed(int speed) {
		if (!enabled)
			enable();
		
		// TODO Auto-generated method stub
	}
	
}
