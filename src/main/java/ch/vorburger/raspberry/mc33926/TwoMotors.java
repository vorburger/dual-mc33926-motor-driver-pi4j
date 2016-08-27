package ch.vorburger.raspberry.mc33926;

public class TwoMotors {

	public final GpioMotor motor1;
	public final GpioMotor motor2;

	public TwoMotors(GpioMotor motor1, GpioMotor motor2) {
		super();
		this.motor1 = motor1;
		this.motor2 = motor2;
	}

	public GpioMotor motor1() {
		return motor1;
	}

	public GpioMotor motor2() {
		return motor2;
	}

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
