package ch.vorburger.raspberry.mc33926;

import static com.pi4j.wiringpi.Gpio.PWM_MODE_MS;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.wiringpi.Gpio;

public class Motor extends AbstractMotor {
	// private static final Logger LOG = LoggerFactory.getLogger(Motor.class);

	/**
	 * Motor speeds for this library are specified as numbers between -MAX_SPEED and MAX_SPEED, inclusive.
	 */
	public static final int MAX_SPEED = 480; // 19.2 MHz / 2 / 480 = 20 kHz

	private GpioPinPwmOutput pwmGpioPin;
	private GpioPinDigitalOutput directionGpioPin;
	private GpioPinDigitalOutput enableGpioPin;

	private boolean enabled = false;

	public Motor(Pin pwmPin, Pin directionPin, Pin enablePin) {
		GpioController gpio = GpioFactory.getInstance();

		Gpio.pwmSetMode(PWM_MODE_MS);
		Gpio.pwmSetRange(MAX_SPEED);
		Gpio.pwmSetClock(2);

		pwmGpioPin = gpio.provisionPwmOutputPin(pwmPin, "pwm");
		pwmGpioPin.setPwmRange(MAX_SPEED);

		directionGpioPin = gpio.provisionDigitalOutputPin(directionPin, "direction");
		enableGpioPin = gpio.provisionDigitalOutputPin(enablePin, "enable", PinState.LOW);
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

		boolean direction;
		if (speed < 0) {
			speed = -speed;
			direction = true;
		} else {
			direction = false;
		}

		if (speed > MAX_SPEED) {
			speed = MAX_SPEED;
		} else if (speed < -MAX_SPEED) {
			speed = -MAX_SPEED;
		}

		directionGpioPin.setState(direction);
		pwmGpioPin.setPwm(speed);
	}

}
