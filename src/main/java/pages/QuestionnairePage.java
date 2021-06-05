package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class QuestionnairePage extends BasePage {

	HomePage home = new HomePage(driver);

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/editModeIv")
	WebElement selectImage;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/cropView")
	WebElement image;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/submitIv")
	WebElement submit;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/submitFb")
	WebElement submitRecords;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/falseBtn")
	WebElement falseButton;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/trueBtn")
	WebElement trueButton;

	@FindBy(xpath = "//android.widget.RelativeLayout")
	List<WebElement> managerImage;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/recordCheckBox")
	List<WebElement> checkBox;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/rejectBtn")
	WebElement reject;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/approveFb")
	WebElement approve;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/positiveBtn")
	WebElement okAlert;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/backIv")
	WebElement back;

	@FindBy(id = "co.nayan.c3specialist_v2.qa_new:id/positiveBtn")
	WebElement positive;

	public QuestionnairePage(WebDriver driver) {
		super(driver);
	}

	public void selectImage() {

		wait.forElementToBeVisible(image);
		cropping(image);
	}

	public void clickOnSelect() {

		wait.forElementToBeVisible(selectImage);
		click(selectImage);
	}

	public void clickOnSubmit() {

		wait.forElementToBeVisible(submit);
		click(submit);
	}

	public void clickOnBack() {

		wait.forElementToBeVisible(back);
		click(back);
	}

	public void annoateRecords() {

		for (int i = 0; i < 5; i++) {
			pause(1500);
			clickOnSelect();
			pause(1500);
			selectImage();
			pause(1500);
			clickOnSubmit();
		}
		clickOnBack();
	}

	public void clickOnTrue() {

		wait.forElementToBeVisible(trueButton);
		click(trueButton);
	}

	public void clickOnFalse() {

		try {
			wait.forElementToBeVisible(falseButton);
			click(falseButton);
		} catch (Exception e) {
			home.clickOnStartWork();
		}
	}

	public void clickOnOkAlert() {

		wait.forElementToBeVisible(okAlert);
		click(okAlert);
	}

	public void specialist02Verification() {

		pause(3000);
		for (int i = 0; i < 5; i++)
			clickOnTrue();
		clickOnOkAlert();
	}

	public void specialist03Verification() {
		
		pause(3000);
		for (int i = 0; i < 5; i++)
			clickOnTrue();
		clickOnOkAlert();
	}

	public void specialist04Verification() {
		
		pause(3000);
		for (int i = 0; i < 5; i++)
			clickOnTrue();
		clickOnOkAlert();
	}

	public void specialist05Verification() {

		pause(3000);
		for (int i = 0; i < 5; i++)
			clickOnTrue();
		clickOnOkAlert();
	}

	public void longPressOnImage() {

		Actions action = new Actions(driver);
		action.clickAndHold(managerImage.get(0)).build().perform();
	}

	public void selectAllImages() {
		for (int i = 0; i < managerImage.size(); i++) {
			wait.forElementToBeVisible(managerImage.get(i));
			click(managerImage.get(i));
			verticalScroll();
		}
	}

	public void clickOnApprove() {

		wait.forElementToBeVisible(approve);
		click(approve);
	}

	public void clickOnReject() {

		wait.forElementToBeVisible(reject);
		click(reject);
	}

	public void clickOnConfirmReject() {

		wait.forElementToBeVisible(positive);
		click(positive);
	}

	public void clickOnSubmitRecords() {

		wait.forElementToBeVisible(submitRecords);
		click(submitRecords);
	}

	public void managerValidation01() {

		longPressOnImage();
		selectAllImages();
		clickOnReject();
		clickOnConfirmReject();
		clickOnSubmitRecords();
		clickOnConfirmReject();
		clickOnOkAlert();
	}

	public void manager01Validation() {

		for (int i = 0; i < 5; i++)
			clickOnFalse();
		try {
			clickOnOkAlert();
		} catch (Exception e) {
			clickOnFalse();
			clickOnOkAlert();
		}
	}

	public void manager05Validation() {

		for (int i = 0; i < 5; i++)
			clickOnSubmit();
		clickOnOkAlert();
	}

	public void manager02Validation() {

		for (int i = 0; i < 5; i++)
			clickOnFalse();
		try {
			clickOnOkAlert();
		} catch (Exception e) {
			clickOnFalse();
			clickOnOkAlert();
		}
	}

	public void manager03Validation() {

		for (int i = 0; i < 5; i++)
			clickOnFalse();
		try {
			clickOnOkAlert();
		} catch (Exception e) {
			clickOnFalse();
			clickOnOkAlert();
		}
	}

	public void manager04Validation() {

		for (int i = 0; i < 5; i++)
			clickOnFalse();
		try {
			clickOnOkAlert();
		} catch (Exception e) {
			clickOnFalse();
			clickOnOkAlert();
		}
	}
}