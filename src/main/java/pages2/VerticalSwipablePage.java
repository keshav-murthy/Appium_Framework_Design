package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class VerticalSwipablePage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	private static final Logger lOGGER = LogManager.getLogger(VerticalSwipablePage.class.getName());

	public VerticalSwipablePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void swipeItems() {

		double j = 0.2;
		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(0));
			if (!(i % 2 == 0)) {
				scrollOrSwipe(j, 0.2, j, 0.8);
			} else {
				scrollOrSwipe(j, 0.8, j, 0.2);
				wait.forElementToBeVisible(ok);
				click(ok);
				j = j + 0.1;
			}
			lOGGER.info("Swiping the items and clicking on button present under it");
		}
	}
}