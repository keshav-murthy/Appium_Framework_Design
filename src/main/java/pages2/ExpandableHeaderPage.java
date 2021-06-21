package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ExpandableHeaderPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/snackbar_text")
	WebElement alert;

	private static final Logger lOGGER = LogManager.getLogger(ExpandableHeaderPage.class.getName());

	public ExpandableHeaderPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void verifyItems() {

		wait.forElementToBeVisible(items.get(1));
		click(items.get(1));
		for (int j = 1; j < items.size() - 3; j++) {
			click(items.get(j + 1));
			wait.forElementToBeVisible(alert);
			String alertText = alert.getText();
			alertText = alertText.substring(alertText.lastIndexOf('-') + 1);
			lOGGER.info("Fetching text from the alert pop-up");
			Assert.assertEquals(Integer.parseInt(alertText), (j - 1));
			lOGGER.info("Verifying whether clicked correct item or not");
		}
		click(items.get(1));
	}

}