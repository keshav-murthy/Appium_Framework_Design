package Demo;

import static commons.Configuration.settings_app_activity;
import static commons.Configuration.settings_app_package;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.DisplayPage;
import pages2.SettingsHomePage;

public class ProgressBar extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp(settings_app_package.asString(), settings_app_activity.asString());
	}

	@Test(priority = 1)
	public void verifyingProgressBar() {

		SettingsHomePage settings = new SettingsHomePage(driver);
		settings.clickOnSearch();
		settings.enterIntoSearch();
		settings.clickOnDisplay();
		DisplayPage display=new DisplayPage(driver);
		display.clickOnBrightnessLevel();
		display.adjustingProgressBar();
	}
}