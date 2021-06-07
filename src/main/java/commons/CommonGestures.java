package commons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("rawtypes")
public class CommonGestures {

	protected AndroidDriver<WebElement> driver;

	protected static ExplicitWait wait;

	protected CommonGestures(AndroidDriver<WebElement> driver) {
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

	public WebElement scrollToElementWithText(String text) {
		WebElement element = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
		return element;
	}

	public void mobileKeys(AndroidKey key) {

		driver.pressKey(new KeyEvent().withKey(key));
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

		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		int width = size.width;
		int height = size.height;
		int middleOfX = width / 2;
		int startYCoordinate = (int) (height * .7);
		int endYCoordinate = (int) (height * .2);

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

	public static void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}