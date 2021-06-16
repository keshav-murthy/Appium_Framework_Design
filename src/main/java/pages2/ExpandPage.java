package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class ExpandPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (MINIMAL)']")
	WebElement expandMin;

	@FindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (BASIC)']")
	WebElement expandBasic;

	@FindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (ADD/REMOVE ITEMS)']")
	WebElement addOrRemove;

	@FindBy(xpath = "//android.widget.Button[@text='EXPANDABLE (GROUPS ALREADY EXPANDED)']")
	WebElement groups;

	private static final Logger lOGGER = LogManager.getLogger(ExpandPage.class.getName());

	public ExpandPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectExpandMin() {

		wait.forElementToBeVisible(expandMin);
		click(expandMin);
		lOGGER.info("Selecting exapnd minimum from the list");
	}

	public void selectExpandBasic() {

		wait.forElementToBeVisible(expandBasic);
		click(expandBasic);
		lOGGER.info("Selecting expand basic from the list");
	}

	public void selectAddOrRemoveItem() {

		wait.forElementToBeVisible(addOrRemove);
		click(addOrRemove);
		lOGGER.info("Selecting add Or Remove from the list");
	}

	public void selectExpandInGroups() {

		wait.forElementToBeVisible(groups);
		click(groups);
		lOGGER.info("Selecting Expand In Groups from the list");
	}
}