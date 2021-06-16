package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ExpandBasicPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	private static final Logger lOGGER = LogManager.getLogger(ExpandBasicPage.class.getName());

	public ExpandBasicPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void expandItems() {

		for (int i = 0; i < 3; i++) {
			wait.forElementToBeVisible(items.get(i));
			click(items.get(i));
			Assert.assertEquals(items.size(), 7);
			click(items.get(i));
		}
		lOGGER.info("Expanding and verfying display of items present inside");
	}
}