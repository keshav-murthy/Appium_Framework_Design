package Demo;

import static commons.Configuration.app_activity;
import static commons.Configuration.app_package;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.ApiDemosPage;
import pages2.ConfirmationPage;
import pages2.HomePage;
import pages2.SeekBarPage;
import pages2.ViewsPage;

public class ProgressBar extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp(app_package.asString(), app_activity.asString());
	}

	@Test()
	public void verifyingProgressBar() {

		ConfirmationPage confirm = new ConfirmationPage(driver);
		confirm.clickOnOk();
		HomePage home = new HomePage(driver);
		home.clickOnApiDemos();
		ApiDemosPage api = new ApiDemosPage(driver);
		api.clickOnViews();
		ViewsPage views = new ViewsPage(driver);
		views.clickOnSeekBar();
		SeekBarPage seek = new SeekBarPage(driver);
		seek.selectRange();
		seek.verifyProgress();
	}
}