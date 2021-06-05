package commons;

import static commons.Capabilities.device_name;
import static commons.Capabilities.platform_name;
import static commons.Capabilities.version;
import static commons.Configuration.appium_server_url;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import listener.ListenerTest;;

@Listeners(ListenerTest.class)
public class TestBase {

	public AndroidDriver<WebElement> driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public AppiumServiceBuilder builder = new AppiumServiceBuilder();
	public AppiumDriverLocalService service;

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		startServer();
		InitializePropertyFile.loadPropertyFile();
		setUpCapabilities();
	}

	@AfterMethod
	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
				stopServer();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setUpCapabilities() throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.VERSION, version.asString());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name.asString());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name.asString());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
		cap.setCapability(MobileCapabilityType.NO_RESET, "false");
	}

	public void installApp(String apkName, String appPackage, String appActivity) throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + File.separator + "app" + File.separator + apkName);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		this.driver = new AndroidDriver<WebElement>(new URL(appium_server_url.asString()), cap);
	}

	public void openInstalledApp(String appPackage, String appActivity) throws MalformedURLException {

		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		this.driver = new AndroidDriver<WebElement>(new URL(appium_server_url.asString()), cap);
	}

	public void startServer() {

		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	public void stopServer() {
		service = AppiumDriverLocalService.buildService(builder);
		service.stop();
	}
}