package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SeekBarPage extends CommonGestures {

	@FindBy(id = "com.touchboarder.android.api.demos:id/seek")
	WebElement seekBar;

	@FindBy(id = "com.touchboarder.android.api.demos:id/progress")
	WebElement percentageDisplay;

	private static final Logger lOGGER = LogManager.getLogger(SeekBarPage.class.getName());

	public SeekBarPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectRange() {

		wait.forElementToBeVisible(seekBar);
		progressBar(seekBar, 55);
		lOGGER.info("Setting the particular range in the progress/seek bar ");
	}

	public void verifyProgress() {

		wait.forElementToBeVisible(percentageDisplay);
		String display = percentageDisplay.getText();
		display = display.substring(0, display.indexOf('f') - 1);
		int display1=Integer.parseInt(display);
		Assert.assertEquals(display1,55);
	}
}