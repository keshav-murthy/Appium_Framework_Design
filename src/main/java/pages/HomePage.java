package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.BasePage;

public class HomePage extends BasePage {

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/startWorkContainer")
	WebElement startWork;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/homeMessageTxt")
	WebElement message;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyTest(String expected) {

		wait.forElementToBeVisible(message);
		String actual = message.getText();
		Assert.assertTrue(actual.contains(expected));
	}

	public void clickOnStartWork() {

		wait.forElementToBeVisible(startWork);
		click(startWork);
		pause(5000);
	}
}