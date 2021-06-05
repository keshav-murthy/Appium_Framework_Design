package Demo;

import static commons.Configuration.app_activity;
import static commons.Configuration.app_package;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ApiDemos_Practice extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp(app_package.asString(), app_activity.asString());
	}

	@Test(priority = 1)
	public void textField() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();

		// AndroidElement list = (AndroidElement)
		// driver.findElement(By.className("android.widget.TextView"));

		MobileElement listItems = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Views\"));"));

		listItems.click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Controls']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='04. Holo Dark Theme']")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("keshav");
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 2']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 1']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 2']")).click();

	}
}
