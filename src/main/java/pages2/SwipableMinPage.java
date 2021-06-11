package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SwipableMinPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "com.touchboarder.android.api.demos:id/progress")
	WebElement percentageDisplay;

	private static final Logger lOGGER = LogManager.getLogger(SwipableMinPage.class.getName());

	public SwipableMinPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void swipeItems() {

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.2, 0.2, 0.8, 0.2);
		}
		lOGGER.info("Swiping the item list left to right");
	}

	public void verifyProgress() {

		wait.forElementToBeVisible(percentageDisplay);
		String display = percentageDisplay.getText();
		display = display.substring(0, display.indexOf('f') - 1);
		int display1 = Integer.parseInt(display);
		Assert.assertEquals(display1, 55);
	}
}