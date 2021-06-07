package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ViewsPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='Controls']")
	WebElement controls;

	private static final Logger lOGGER = LogManager.getLogger(ViewsPage.class.getName());
	
	public ViewsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnControls() {

		wait.forElementToBeVisible(controls);
		click(controls);
		lOGGER.info("Selecting Controls section from the list of Views");
	}
}