package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.BasicDragPage;
import pages2.DragPage;
import pages2.DraggableWithSectionPage;
import pages2.HomePage;
import pages2.LongPressDragPage;
import pages2.MinimunDragPage;
import pages2.SwipePage;
import pages2.VerticalSwipablePage;
import pages2.ViewPagerSwipablePage;

public class DraggableTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

//	@Test(priority = 1)
	public void verifyMinDrag() {

		DragPage drag = new DragPage(driver);
		drag.selectDragMin();
		MinimunDragPage basic = new MinimunDragPage(driver);
		basic.dragItems();
	}

//	@Test(priority = 2)
	public void verifyBasicDrag() {

		DragPage drag = new DragPage(driver);
		drag.selectDragBasic();
		BasicDragPage min = new BasicDragPage(driver);
		min.dragItems();
	}

//	@Test(priority = 3)
	public void verifyLongPressSwipe() {

		DragPage drag = new DragPage(driver);
		drag.selectDragLongPress();
		LongPressDragPage min = new LongPressDragPage(driver);
		min.dragItems();
	}

	@Test(priority = 4)
	public void verifyButtonUnderSwipe() {

		DragPage drag = new DragPage(driver);
		drag.draggableWithSection();
		DraggableWithSectionPage sec = new DraggableWithSectionPage(driver);
		sec.dragItems();
	}

//	@Test(priority = 5)
	public void verifyVerticalSwipable() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.verticalSwipable();
		VerticalSwipablePage swipable = new VerticalSwipablePage(driver);
		swipable.swipeItems();
	}

//	@Test(priority = 6)
	public void verifyViewPagerSwipable() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.viewPagerSwipable();
		ViewPagerSwipablePage swipable = new ViewPagerSwipablePage(driver);
		swipable.swipeItems();
	}
}