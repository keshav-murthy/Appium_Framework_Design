package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class SwipePage extends CommonGestures {

	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (MINIMAL)']")
	WebElement swipableMin;

	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (BASIC)']")
	WebElement swipableBasic;

	@FindBy(xpath = "//android.widget.Button[@text='SWIPE ON LONG PRESS']")
	WebElement swipableLongPress;

	@FindBy(xpath = "//android.widget.Button[@text='BUTTON UNDER SWIPEABLE ITEM']")
	WebElement buttonUnderSwipe;

	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE (VERTICAL)']")
	WebElement verticalSwipable;

	@FindBy(xpath = "//android.widget.Button[@text='SWIPEABLE WITH VIEWPAGER']")
	WebElement viewPagerSwipable;

	private static final Logger lOGGER = LogManager.getLogger(SwipePage.class.getName());

	public SwipePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectSwipableMin() {

		wait.forElementToBeVisible(swipableMin);
		click(swipableMin);
		lOGGER.info("Selecting Swipable minimum from the list");
	}

	public void selectSwipableBasic() {

		wait.forElementToBeVisible(swipableBasic);
		click(swipableBasic);
		lOGGER.info("Selecting Swipable basic from the list");
	}

	public void selectSwipableLongPress() {

		wait.forElementToBeVisible(swipableLongPress);
		click(swipableLongPress);
		lOGGER.info("Selecting Swipable Long Press from the list");
	}

	public void buttonUnderSwipable() {

		wait.forElementToBeVisible(buttonUnderSwipe);
		click(buttonUnderSwipe);
		lOGGER.info("Selecting Button Under Swipe from the list");
	}

	public void verticalSwipable() {

		wait.forElementToBeVisible(verticalSwipable);
		click(verticalSwipable);
		lOGGER.info("Selecting Vertical Swipable from the list");
	}

	public void viewPagerSwipable() {

		wait.forElementToBeVisible(viewPagerSwipable);
		click(viewPagerSwipable);
		lOGGER.info("Selecting View Pager Swipable from the list");
	}
}