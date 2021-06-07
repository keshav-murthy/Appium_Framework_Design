package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ApiDemosPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	WebElement apiDemos;

	private static final Logger lOGGER = LogManager.getLogger(ApiDemosPage.class.getName());

	public ApiDemosPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnViews() {
		WebElement views = scrollToElementWithText("Views");
		wait.forElementToBeVisible(views);
		click(views);
		lOGGER.info("Scrolling till the Views is visible and later clicking on it");
	}
}