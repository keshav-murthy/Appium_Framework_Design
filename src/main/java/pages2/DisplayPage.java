package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class DisplayPage extends CommonGestures {
	
	@FindBy(xpath = "//android.widget.TextView[@text='Brightness level']")
	WebElement brightnessLevel;
	
	@FindBy(className = "android.widget.SeekBar")
	WebElement seekBar;
	
	private static final Logger lOGGER = LogManager.getLogger(DisplayPage.class.getName());

	public DisplayPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public void clickOnBrightnessLevel() {

		wait.forElementToBeVisible(brightnessLevel);
		click(brightnessLevel);
		lOGGER.info("Selecting Brightness Level");
	}
	
	public void adjustingProgressBar() {

		wait.forElementToBeVisible(seekBar);
		progressBar(seekBar,50);
		lOGGER.info("Adjusting the brightness level using progress bar");
	}
}