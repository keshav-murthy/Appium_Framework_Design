package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SwipePage extends CommonGestures {

	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (MINIMAL)']")
	WebElement swipableMin;
	
	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (BASIC)']")
	WebElement swipableBasic;

	@FindBy(id = "com.touchboarder.android.api.demos:id/progress")
	WebElement percentageDisplay;

	private static final Logger lOGGER = LogManager.getLogger(SwipePage.class.getName());

	public SwipePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectSwipableMin() {

		wait.forElementToBeVisible(swipableMin);
		click(swipableMin);
		lOGGER.info("Selecting Swipable minimum from the list");
	}
	
	public void selectSwipableBasic() {

		wait.forElementToBeVisible(swipableBasic);
		click(swipableBasic);
		lOGGER.info("Selecting Swipable basic from the list");
	}

	public void verifyProgress() {

		wait.forElementToBeVisible(percentageDisplay);
		String display = percentageDisplay.getText();
		display = display.substring(0, display.indexOf('f') - 1);
		int display1=Integer.parseInt(display);
		Assert.assertEquals(display1,55);
	}
}