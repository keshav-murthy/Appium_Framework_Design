package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SettingsHomePage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='Search settings']")
	WebElement searchField;

	@FindBy(className = "miui.widget.ClearableEditText")
	WebElement editText;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Display']")
	WebElement display;	
	
	private static final Logger lOGGER = LogManager.getLogger(SettingsHomePage.class.getName());

	public SettingsHomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnSearch() {

		wait.forElementToBeVisible(searchField);
		click(searchField);
		lOGGER.info("Clicking on search field");
	}
	
	public void enterIntoSearch() {

		wait.forElementToBeVisible(editText);
		sendKeys(editText,"Display");
		lOGGER.info("Entering text to be searched in the search field");
	}
	
	public void clickOnDisplay() {

		wait.forElementToBeVisible(display);
		click(display);
		lOGGER.info("Clicking on Display");
	}

	public void scrollToDisplay() {
		scrollToElementWithText("Display");
	}
}