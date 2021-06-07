package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ControlsPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='04. Holo Dark Theme']")
	WebElement holoDarkTheme;
	
	private static final Logger lOGGER = LogManager.getLogger(ControlsPage.class.getName());

	public ControlsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnDarkTheme() {

		wait.forElementToBeVisible(holoDarkTheme);
		click(holoDarkTheme);
		lOGGER.info("Selecting Holo Dark Theme section from the list of Controls");
	}
}