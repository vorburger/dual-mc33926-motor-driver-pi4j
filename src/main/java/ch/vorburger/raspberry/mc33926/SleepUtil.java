package ch.vorburger.raspberry.mc33926;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepUtil {
	private static final Logger LOG = LoggerFactory.getLogger(Motor.class);

	public static void sleepSeconds(double second) {
		try {
			Thread.sleep((long) (second * 1000));
		} catch (InterruptedException e) {
			LOG.warn("sleep() InterruptedException", e);
		}

	}

	private SleepUtil() {
	}
}