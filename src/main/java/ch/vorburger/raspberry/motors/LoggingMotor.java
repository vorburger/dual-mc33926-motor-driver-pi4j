package ch.vorburger.raspberry.motors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMotor extends Motor {

	private static final Logger LOG = LoggerFactory.getLogger(Motor.class);
	private final String name;

	private boolean isEnabled = false;
	private int speed = Integer.MAX_VALUE;

	public LoggingMotor(String name) {
		super();
		this.name = name;
	}

	@Override
	public void enable() {
		if (!isEnabled) {
			LOG.info("enabled {} motor", name);
			isEnabled = true;
		}
	}

	@Override
	public void disable() {
		if (!isEnabled) {
			LOG.info("disabled {} motor", name);
			isEnabled = false;
		}
	}

	@Override
	public void setSpeed(int speed) {
		if (this.speed != speed) {
			LOG.info("set speed {} on {} motor", speed, name);
			this.speed = speed;
		}
	}

}
