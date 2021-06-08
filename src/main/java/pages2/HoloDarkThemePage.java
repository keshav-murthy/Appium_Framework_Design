package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class HoloDarkThemePage extends CommonGestures {

	@FindBy(className = "android.widget.EditText")
	WebElement textField;

	@FindBy(xpath = "//android.widget.CheckBox[@text='Checkbox 1']")
	WebElement checkBox1;

	@FindBy(xpath = "//android.widget.CheckBox[@text='Checkbox 2']")
	WebElement checkBox2;

	@FindBy(xpath = "//android.widget.RadioButton[@text='RadioButton 1']")
	WebElement radioButton1;

	@FindBy(xpath = "//android.widget.RadioButton[@text='RadioButton 2']")
	WebElement radioButton2;

	private static final Logger lOGGER = LogManager.getLogger(HoloDarkThemePage.class.getName());

	public HoloDarkThemePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void enterText() {

		wait.forElementToBeVisible(textField);
		sendKeys(textField, "Keshav");
		lOGGER.info("Entering some values into the text field");
		mobileKeys(AndroidKey.BACK);
		lOGGER.info("Clicking on back button to disable keyboard appering on screen");
	}

	public void clickOnCheckBox1() {

		wait.forElementToBeVisible(checkBox1);
		click(checkBox1);
		lOGGER.info("Clicking on CheckBox1");
	}

	public void clickOnCheckBox2() {

		wait.forElementToBeVisible(checkBox2);
		click(checkBox2);
		lOGGER.info("Clicking on CheckBox2");
	}

	public void clickOnRadioButton1() {

		wait.forElementToBeVisible(radioButton1);
		click(radioButton1);
		lOGGER.info("Clicking on 1st Radio Button ");
	}

	public void clickOnRadioButton2() {

		wait.forElementToBeVisible(radioButton2);
		click(radioButton2);
		lOGGER.info("Clicking on 2nd Radio Button");
	}
	
	public void verifyTest() {
		
		Assert.assertTrue((radioButton1.getAttribute("checked")).equals("false"));
		Assert.assertTrue((radioButton2.getAttribute("checked")).equals("true"));
		lOGGER.info("Verifying the state of Radio buttons after the execution");
	}
}