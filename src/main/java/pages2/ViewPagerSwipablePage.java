package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ViewPagerSwipablePage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	@FindBy(xpath = "//android.widget.TextView[@text='PAGE 1']")
	WebElement page1;

	@FindBy(xpath = "//android.widget.TextView[@text='PAGE 2']")
	WebElement page2;

	private static final Logger lOGGER = LogManager.getLogger(ViewPagerSwipablePage.class.getName());

	public ViewPagerSwipablePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void swipeItems() {

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.5, 0.2, 0.8, 0.2);
		}

		wait.forElementToBeVisible(page2);
		click(page2);
		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			scrollOrSwipe(0.5, 0.2, 0.2, 0.2);
		}
		lOGGER.info("Swiping the items in 2 different pages");
	}
}