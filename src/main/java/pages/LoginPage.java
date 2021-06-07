package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//android.widget.EditText[@text='Email or Username']")
	WebElement username;

	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	WebElement password;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/buttonSubmit")
	WebElement signIn;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/nextBtn")
	WebElement next;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/getStartedBtn")
	WebElement startWorking;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/englishTxt")
	WebElement english;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/hindiTxt")
	WebElement hindi;

	public LoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void enterUsername(String Username) {

		wait.forElementToBeVisible(username);
		sendKeys(username, Username);
	}

	public void enterPassword(String Password) {

		wait.forElementToBeVisible(password);
		sendKeys(password, Password);
	}

	public void clickOnSignIn() {

		wait.forElementToBeVisible(signIn);
		click(signIn);
	}

	public void clickOnNextButton() {

		wait.forElementToBeVisible(next);
		click(next);
	}

	public void clickOnStartWorking() {

		wait.forElementToBeVisible(startWorking);
		click(startWorking);
		pause(3000);
	}

	public void clickOnEnglish() {

		wait.forElementToBeVisible(english);
		click(english);
	}

	public void loginProcess(String Username, String Password) {
		enterUsername(Username);
		enterPassword(Password);
		clickOnSignIn();
		clickOnNextButton();
		clickOnNextButton();
		clickOnStartWorking();
		clickOnEnglish();
	}
}