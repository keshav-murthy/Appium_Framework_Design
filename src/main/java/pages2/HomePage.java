package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends CommonGestures {

	@FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	WebElement apiDemos;

	@FindBy(xpath = "//android.widget.TextView[@text='SWIPE']")
	WebElement swipe;

	@FindBy(xpath = "//android.widget.TextView[@text='EXPAND']")
	WebElement expand;

	@FindBy(xpath = "//android.widget.TextView[@text='HEADER']")
	WebElement header;

	@FindBy(xpath = "//android.widget.TextView[@text='ADAPTER']")
	WebElement adapter;

	@FindBy(xpath = "//android.widget.TextView[@text='ADVANCED']")
	WebElement advanced;

	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	public HomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnApiDemos() {

		wait.forElementToBeVisible(apiDemos);
		click(apiDemos);
		lOGGER.info("Selecting APIDemos option from the list avalaible on home page");
	}

	public void clickOnSwipe() {

		wait.forElementToBeVisible(swipe);
		click(swipe);
		lOGGER.info("Selecting swipe option from the list avalaible on home page");
	}

	public void clickOnExpand() {

		wait.forElementToBeVisible(expand);
		click(expand);
		lOGGER.info("Selecting expand option from the list avalaible on home page");
	}

	public void clickOnHeader() {

		wait.forElementToBeVisible(header);
		click(header);
		lOGGER.info("Selecting header option from the list avalaible on home page");
	}

	public void clickOnAdapter() {

		wait.forElementToBeVisible(adapter);
		click(adapter);
		lOGGER.info("Selecting adapter option from the list avalaible on home page");
	}

	public void clickOnAdvanced() {

		wait.forElementToBeVisible(advanced);
		click(advanced);
		lOGGER.info("Selecting advanced option from the list avalaible on home page");
	}
}