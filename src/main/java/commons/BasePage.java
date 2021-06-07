package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage {

	protected AndroidDriver<WebElement> driver;

	protected static ExplicitWait wait;

	protected BasePage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new ExplicitWait(driver);
		PageFactory.initElements(driver, this);
	}

	public static void click(WebElement webElement) {
		click(webElement, Timeouts.EXPLICIT);
	}

	public static void click(WebElement webElement, int timeOutInSeconds) {
		wait.forElementToBeClickable(webElement, timeOutInSeconds, Timeouts.POLLING_INTERVAL);
		webElement.click();
	}

	public static void sendKeys(WebElement webElement, String value, int timeOutInSeconds) {
		webElement.clear();
		webElement.sendKeys(value);
	}

	public static void sendKeys(WebElement webElement, String value) {
		sendKeys(webElement, value, Timeouts.EXPLICIT);
	}

	public void dropDownMethod(WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("Value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("Index")) {
			int i = Integer.parseInt(value);
			s.selectByIndex(i);
		}
	}

	/* This method will validate partial text */
	public static boolean getTextPartialValidate(WebElement element, String value) {
		boolean flag = false;
		System.out.println("Extracted text is:" + element.getText());
		if (element.getText().contains(value)) {
			System.out.println("Partial Text comparsion is successful");
			flag = true;
		} else {
			System.out.println("Partial Text comparsion is unsuccessful");
		}
		return flag;

	}

	/* This is wrapper method to check the web element is displayed on the page */
	public boolean isElementPresence(WebElement webElement) {
		return webElement.isEnabled();
	}

	/* This method will clear the Text */
	public void clearText(WebElement element) {
		element.clear();
	}

	/* This is wrapper method to check the web element is displayed on the page */
	public boolean isElementDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public WebElement FindElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void windowHandling() {

		Set<String> windowID = driver.getWindowHandles();
		for (String i : windowID)
			driver.switchTo().window(i);
	}

	public void defaultWindow() {

		Set<String> windowID = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowID);
		for (int i = 0; i < window.size(); i++)
			driver.switchTo().window(window.get(0));
	}

	public void closeCurrentWindow() {

		Set<String> windowID = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowID);
		for (int i = 0; i < window.size(); i++)
			driver.switchTo().window(window.get(1)).close();
		;
	}

	public void clickOnOKAlert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}