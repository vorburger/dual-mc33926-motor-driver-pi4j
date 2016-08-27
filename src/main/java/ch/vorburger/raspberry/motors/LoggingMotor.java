package ch.vorburger.raspberry.motors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMotor extends Motor {

	private static final Logger LOG = LoggerFactory.getLogger(Motor.class);
	private final String name;

	public LoggingMotor(String name) {
		super();
		this.name = name;
	}

	@Override
	public void enable() {
		LOG.info("enabled {} motor", name);
	}

	@Override
	public void disable() {
		LOG.info("disabled {} motor", name);
	}

	@Override
	public void setSpeed(int speed) {
		LOG.info("set speed {} on {} motor", speed, name);
	}

}
