package ch.vorburger.raspberry.motors;

public class ReverseMotor extends Motor {

	private final Motor delegatingMotor;

	public ReverseMotor(Motor delegatingMotor) {
		this.delegatingMotor = delegatingMotor;
	}

	@Override
	public void setSpeed(int speed) {
		delegatingMotor.setSpeed( -speed);
	}

	@Override
	public void enable() {
		delegatingMotor.enable();
	}

	@Override
	public void disable() {
		delegatingMotor.disable();
	}
}
