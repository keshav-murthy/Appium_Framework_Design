package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ExpandInGroupsPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/menu_add_group_bottom_2")
	WebElement addGroupBelow;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_above")
	List<WebElement> addGroupAbove;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_below")
	List<WebElement> addChildBelow;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_above")
	List<WebElement> addChildAbove;

	@FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])[3]//android.widget.TextView")
	List<WebElement> frames;

	private static final Logger lOGGER = LogManager.getLogger(ExpandInGroupsPage.class.getName());

	public ExpandInGroupsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void expandItems() {

		wait.forElementToBeVisible(addGroupBelow);
		click(addGroupBelow);
		for (int i = 0; i < items.size(); i++) {
			wait.forElementToBeVisible(items.get(i));
			Assert.assertTrue(items.size() >= 6);
			click(items.get(i));
		}
		lOGGER.info("Expanding and verfying display of items present inside");
	}
}