package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	WebElement apiDemos;	
	
	@FindBy(xpath = "//android.widget.TextView[@text='SWIPE']")
	WebElement swipe;
	
	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	public HomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnApiDemos() {

		wait.forElementToBeVisible(apiDemos);
		click(apiDemos);
		lOGGER.info("Selecting APIDemos option from the list avalaible on home page");
	}
	
	public void clickOnSwipe() {

		wait.forElementToBeVisible(swipe);
		click(swipe);
		lOGGER.info("Selecting SWIPE option from the list avalaible on home page");
	}
}