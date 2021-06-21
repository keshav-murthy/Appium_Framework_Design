package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class HeaderPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.Button[@text='HEADER/FOOTER (MINIMAL)']")
	WebElement headerMin;

	@FindBy(xpath = "//android.widget.Button[@text='EXPANDABLE WITH HEADER/FOOTER']")
	WebElement expandableHeader;

	@FindBy(xpath = "//android.widget.Button[@text='HEADER/FOOTER (ADD/REMOVE ITEMS)']")
	WebElement addOrRemove;

	private static final Logger lOGGER = LogManager.getLogger(HeaderPage.class.getName());

	public HeaderPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectHeaderMin() {

		wait.forElementToBeVisible(headerMin);
		click(headerMin);
		lOGGER.info("Selecting Header minimum from the list");
	}

	public void selectExpandableHeader() {

		wait.forElementToBeVisible(expandableHeader);
		click(expandableHeader);
		lOGGER.info("Selecting Expandable Header from the list");
	}

	public void selectAddOrRemove() {

		wait.forElementToBeVisible(addOrRemove);
		click(addOrRemove);
		lOGGER.info("Selecting Add or remove in header from the list");
	}
}