package ch.vorburger.raspberry.motors;

public class TwoMotors {

	public final Motor motor1;
	public final Motor motor2;

	public TwoMotors(Motor motor1, Motor motor2) {
		super();
		this.motor1 = motor1;
		this.motor2 = motor2;
	}

	public Motor motor1() {
		return motor1;
	}

	public Motor motor2() {
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
