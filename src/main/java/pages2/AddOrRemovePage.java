package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class AddOrRemovePage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_below")
	List<WebElement> addGroupBelow;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_group_above")
	List<WebElement> addGroupAbove;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_below")
	List<WebElement> addChildBelow;

	@FindBy(id = "com.h6ah4i.android.example.advrecyclerview:id/button_add_child_above")
	List<WebElement> addChildAbove;

	@FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])[3]//android.widget.TextView")
	List<WebElement> frames;

	private static final Logger lOGGER = LogManager.getLogger(AddOrRemovePage.class.getName());

	public AddOrRemovePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void expandItems() {

		wait.forElementToBeVisible(addGroupBelow.get(0));
		click(addGroupBelow.get(0));
		wait.forElementToBeVisible(addGroupAbove.get(0));
		click(addGroupAbove.get(0));
		wait.forElementToBeVisible(items.get(1));
		click(items.get(1));
		wait.forElementToBeVisible(addChildBelow.get(0));
		click(addChildBelow.get(0));
		wait.forElementToBeVisible(addChildAbove.get(0));
		click(addChildAbove.get(0));
		printGroupContents();
		lOGGER.info("Expanding and verfying display of items present inside");
	}

	public void printGroupContents() {

		for (int i = 3; i < 8; i++) {
			List<WebElement> frames = driver.findElements(By.xpath(
					"(//android.widget.FrameLayout[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'])["
							+ i + "]//android.widget.TextView"));
			System.out.println(frames.get(0).getText());
		}
	}
}