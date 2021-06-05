package commons;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public abstract class BasePage {

	protected AndroidDriver<WebElement> driver;

	protected static ExplicitWait wait;

	protected static JavaScriptHelper js;

	@SuppressWarnings("unchecked")
	protected BasePage(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new ExplicitWait(driver);
		js = new JavaScriptHelper(driver);
		PageFactory.initElements(driver, this);
	}

	public static void click(WebElement webElement) {
		click(webElement, Timeouts.EXPLICIT);
	}

	public static void click(WebElement webElement, int timeOutInSeconds) {
		wait.forElementToBeClickable(webElement, timeOutInSeconds, Timeouts.POLLING_INTERVAL);
//		js.clickElement(webElement);
		webElement.click();
	}

	public static void sendKeys(WebElement webElement, String value, int timeOutInSeconds) {
//		click(webElement, timeOutInSeconds);
		webElement.clear();
		webElement.sendKeys(value);
	}

	public static void sendKeys(WebElement webElement, String value) {
		sendKeys(webElement, value, Timeouts.EXPLICIT);
	}

	public void executeJavascript(String string) {
		js.executeScript(string);
	}

	public void executeJavascript(String string, WebElement element) {
		js.executeScript(string, element);
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

	/* This method will scroll the web page till bottom of the page */
	public static void scrollToBottom() {

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/* This method will scroll the web page till top of the web page */
	public static void scrollToTop() {

		js.executeScript("window.scrollTo(0,0)");

	}

	public static void scrollToPixel(int px) {
		js.executeScript("window.scrollTo(0," + px + ")");
	}

	/* This is wrapper method to check the web element is displayed on the page */
	public boolean isElementDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	/* This method will scroll the web page Vertically till the element is found */
	public static void scrollToElementView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	/* This method will enter value in the input textbox */
	public static void javaScriptSendValue(WebElement element, String val) {
		js.executeScript("arguments[0].value='" + val + "';", element);

	}

	/* This method will click on the web element using javascriptexecutor */
	public static void javaScriptClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);

	}

	public static void actionsEnter() {
		js.actionEnter();
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

	public void dragAndDrop(WebElement source, WebElement target) {

		TouchAction action = new TouchAction(((MobileDriver) driver));
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
	}

	public void progressBar(WebElement source) {

		TouchAction action = new TouchAction(((MobileDriver) driver));
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(source, 250, 250)).release()
				.perform();
	}

	public void verticalScroll() {

		TouchAction  action =new TouchAction(driver);	
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height=size.height;				
		int middleOfX=width/2;
		int startYCoordinate= (int)(height*.7);
		int endYCoordinate= (int)(height*.2);
						
		action.press(PointOption.point(middleOfX, startYCoordinate))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
//		int startX = seekBar.getLocation().getX();
//		int startY = seekBar.getLocation().getY();
//		int endX = seekBar.getSize().getWidth();
//		int moveToXDirectionAt = (int) (endX * 0.5);
//
//		TouchAction act = new TouchAction((PerformsTouchActions) driver);
//		act.press(PointOption.point(startX, startY)).moveTo(PointOption.point(moveToXDirectionAt, startY)).release()
//				.perform();
	}

	public void scrollToText(String text, URL url, DesiredCapabilities capabilities) {
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, capabilities);
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void mobileClick(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException e) {
			element.click();
		}
	}

	public void getTextFromMobileApp(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (NoSuchElementException e) {
			System.out.println(element.getText());
		}
	}

	public void cropping(WebElement element) {
//		Actions crop = new Actions(driver);
//		crop.dragAndDropBy(element, x, y).release().perform();
		
//		System.out.println((image.getLocation().x)+(image.getSize().width*0.25));
//		System.out.println((image.getLocation().y)+(image.getSize().height*0.25));
//		System.out.println((image.getLocation().x)+(image.getSize().width*0.75));
//		System.out.println((image.getLocation().y)+(image.getSize().height*0.75));

		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(50, 500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(700, 800)).release().perform();
	}
}