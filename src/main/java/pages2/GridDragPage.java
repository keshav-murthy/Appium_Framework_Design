package pages2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class GridDragPage extends CommonGestures {

	@FindBy(id = "android:id/text1")
	List<WebElement> items;

	@FindBy(id = "android:id/button1")
	WebElement ok;

	@FindBy(id = "android:id/button1")
	List<WebElement> buttons;

	@FindBy(xpath = "//android.widget.TextView[@text='0 - A']")
	WebElement firstItem;

	@FindBy(xpath = "//android.widget.TextView[@text='1 - B']")
	WebElement secondItem;

	@FindBy(xpath = "//android.widget.TextView[@text='2 - C']")
	WebElement thirdItem;

	@FindBy(xpath = "//android.widget.TextView[@text='3 - D']")
	WebElement fourthItem;

	@FindBy(xpath = "//android.widget.TextView[@text='4 - E']")
	WebElement fifthItem;

	private static final Logger lOGGER = LogManager.getLogger(GridDragPage.class.getName());

	public GridDragPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
//
//	public void dragFirstItem() {
//
//		wait.forElementToBeVisible(firstItem);
//		dragAndDrop(firstItem, fifthItem);
//		lOGGER.info("Interchanging the position of items");
//	}
//
//	public void dragSecondItem() {
//
//		wait.forElementToBeVisible(secondItem);
//		dragAndDrop(secondItem, fourthItem);
//		lOGGER.info("Interchanging the position of items");
//	}
//
//	public void dragThirdItem() {
//
//		wait.forElementToBeVisible(thirdItem);
//		dragAndDrop(thirdItem, thirdItem);
//		lOGGER.info("Interchanging the position of items");
//	}
//
//	public void dragFourthItem() {
//
//		wait.forElementToBeVisible(fourthItem);
//		dragAndDrop(fourthItem, secondItem);
//		lOGGER.info("Interchanging the position of items");
//	}
//
//	public void dragFifthItem() {
//
//		wait.forElementToBeVisible(fifthItem);
//		dragAndDrop(fifthItem, firstItem);
//		lOGGER.info("Interchanging the position of items");
//	}
//
//	public void dragItems() {
//
//		dragFirstItem();
//		dragSecondItem();
//		dragThirdItem();
//		dragFourthItem();
//		dragFifthItem();
//	}

	public void dragItems() {

		for (int i = 0; i < 13; i++) {
			wait.forElementToBeVisible(items.get(i));
			dragAndDrop(items.get(i), items.get(i + 2));
			i = i + 2;
		}
		lOGGER.info("Interchanging the position of items");
	}
}