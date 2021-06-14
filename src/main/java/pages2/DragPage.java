package pages2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonGestures;
import io.appium.java_client.android.AndroidDriver;

public class DragPage extends CommonGestures {

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (MINIMAL)']")
	WebElement dragMin;

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (BASIC)']")
	WebElement dragBasic;

	@FindBy(xpath = "//android.widget.Button[@text='DRAG ON LONG PRESS']")
	WebElement dragLongPress;

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE WITH SECTION']")
	WebElement dragSection;

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (USES ONCHECKCANDROP)']")
	WebElement onCheckAndDrop;

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (GRID LAYOUT)']")
	WebElement gridLayout;

	@FindBy(xpath = "//android.widget.Button[@text='DRAGGABLE (STAGGERED GRID LAYOUT)']")
	WebElement staggeredGridLayout;

	private static final Logger lOGGER = LogManager.getLogger(DragPage.class.getName());

	public DragPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void selectDragMin() {

		wait.forElementToBeVisible(dragMin);
		click(dragMin);
		lOGGER.info("Selecting Draggable minimum from the list");
	}

	public void selectDragBasic() {

		wait.forElementToBeVisible(dragBasic);
		click(dragBasic);
		lOGGER.info("Selecting Draggable basic from the list");
	}

	public void selectDragLongPress() {

		wait.forElementToBeVisible(dragLongPress);
		click(dragLongPress);
		lOGGER.info("Selecting Draggable Long Press from the list");
	}

	public void draggableWithSection() {

		wait.forElementToBeVisible(dragSection);
		click(dragSection);
		lOGGER.info("Selecting Draggable With Section from the list");
	}

	public void dragOnCheckAndDrop() {

		wait.forElementToBeVisible(onCheckAndDrop);
		click(onCheckAndDrop);
		lOGGER.info("Selecting Drag On Check And Drop from the list");
	}

	public void gridLayout() {

		wait.forElementToBeVisible(gridLayout);
		click(gridLayout);
		lOGGER.info("Selecting Grid Layout from the list");
	}

	public void staggeredGridLayout() {

		wait.forElementToBeVisible(staggeredGridLayout);
		click(staggeredGridLayout);
		lOGGER.info("Selecting Staggered Grid Layout from the list");
	}
}