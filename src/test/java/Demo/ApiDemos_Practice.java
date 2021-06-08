package Demo;

import static commons.Configuration.app_activity;
import static commons.Configuration.app_package;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.ApiDemosPage;
import pages2.ConfirmationPage;
import pages2.ControlsPage;
import pages2.HoloDarkThemePage;
import pages2.HomePage;
import pages2.ViewsPage;

public class ApiDemos_Practice extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp(app_package.asString(), app_activity.asString());
	}

	@Test(priority = 1)
	public void textFieldCheckBoxRadioButton() {

		ConfirmationPage confirm = new ConfirmationPage(driver);
		confirm.clickOnOk();
		
		HomePage home = new HomePage(driver);
		home.clickOnApiDemos();

		ApiDemosPage api = new ApiDemosPage(driver);
		api.clickOnViews();
		
		ViewsPage views=new ViewsPage(driver);
		views.clickOnControls();

		ControlsPage controls = new ControlsPage(driver);
		controls.clickOnDarkTheme();

		HoloDarkThemePage holodark = new HoloDarkThemePage(driver);
		holodark.enterText();
		holodark.clickOnCheckBox1();
		holodark.clickOnCheckBox2();
		holodark.clickOnRadioButton1();
		holodark.clickOnRadioButton2();
		holodark.verifyTest();
	}
}