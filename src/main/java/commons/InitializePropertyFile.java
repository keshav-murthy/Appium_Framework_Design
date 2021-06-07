package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InitializePropertyFile {
	public static Properties property;

	public static void loadPropertyFile() throws FileNotFoundException, IOException {
		property = new Properties();
//		String pathToTestData = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
//				+ "config.properties";
		String pathToTestData = System.getProperty("capabilitiesPath");
		property.load(new FileInputStream(pathToTestData));
	}
}