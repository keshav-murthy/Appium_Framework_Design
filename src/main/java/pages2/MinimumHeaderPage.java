package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class MinimumHeaderPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/snackbar_text")
	WebElement alert;

	private static final Logger lOGGER = LogManager.getLogger(MinimumHeaderPage.class.getName());

	public MinimumHeaderPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void verifyItems() {

		for (int i = 1; i < items.size() - 1; i++) {
			wait.forElementToBeVisible(items.get(i));
			click(items.get(i));
			wait.forElementToBeVisible(alert);
			String alertText = alert.getText();
			alertText = alertText.substring(alertText.lastIndexOf(' ') + 1);
			lOGGER.info("Fetching text from the alert pop-up");
			Assert.assertEquals(Integer.parseInt(alertText), (i - 1));
			lOGGER.info("Verifying whether clicked correct item or not");
		}
	}
}