package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SwipableBasicPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	private static final Logger lOGGER = LogManager.getLogger(SwipableBasicPage.class.getName());

	public SwipableBasicPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void swipeItems() {

		double j = 0.2;

		for (int i = 0; i < 5; i++) {
			wait.forElementToBeVisible(items.get(i));
			if (!(i % 2 == 0)) {
				scrollOrSwipe(0.2, j, 0.8, j);
			} else {
				scrollOrSwipe(0.8, j, 0.2, j);
				wait.forElementToBeVisible(ok);
				click(ok);
				j = j + 0.1;
			}
		}
		lOGGER.info("Swiping the item list left to right and vice-versa");
	}
}