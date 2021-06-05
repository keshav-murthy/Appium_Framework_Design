package commons;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Config that is supplied to tests via a properties file. Holds data that is
 * used by the tests and the url of the environment under test.
 */
public enum Capabilities {

	browser_name, version, device_name, platform_name;

	private final String capabilitiesPath = System.getProperty("capabilitiesPath");

	private Properties properties;

	private String value;

	private void init() {
		if (properties == null) {

			// Check config path is available.
			if (capabilitiesPath == null) {
				throw new RuntimeException("You must pass capabilities Path as a system property.");
			}

			properties = new Properties();

			try {
				properties.load(new FileInputStream(capabilitiesPath));
			} catch (Exception e) {
				throw new RuntimeException("Unable to load test properties from:" + capabilitiesPath + ".", e);
			}
		}
		value = (String) properties.get(this.toString());
	}

	public Object getValue() {
		if (value == null) {
			init();
		}
		return value;
	}

	public String asString() {
		return (String) getValue();
	}
}