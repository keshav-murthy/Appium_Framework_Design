package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ConfirmationPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	WebElement ok;

	private static final Logger lOGGER = LogManager.getLogger(ConfirmationPage.class.getName());

	public ConfirmationPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnOk() {

		wait.forElementToBeVisible(ok);
		click(ok);
		lOGGER.info("Clicking on OK button of confirmation page");
	}
}