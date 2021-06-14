package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.ButtonUnderSwipePage;
import pages2.HomePage;
import pages2.SwipableBasicPage;
import pages2.SwipableLongPressPage;
import pages2.SwipableMinPage;
import pages2.SwipePage;
import pages2.VerticalSwipablePage;
import pages2.ViewPagerSwipablePage;

public class SwippingTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

	@Test(priority = 1)
	public void verifyMinSwipe() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.selectSwipableMin();
		SwipableMinPage swipable = new SwipableMinPage(driver);
		swipable.swipeItems();
	}

	@Test(priority = 2)
	public void verifyBasicSwipe() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.selectSwipableBasic();
		SwipableBasicPage swipable = new SwipableBasicPage(driver);
		swipable.swipeItems();
	}

	@Test(priority = 3)
	public void verifyLongPressSwipe() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.selectSwipableLongPress();
		SwipableLongPressPage swipable = new SwipableLongPressPage(driver);
		swipable.swipeItems();
	}

	@Test(priority = 4)
	public void verifyButtonUnderSwipe() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.buttonUnderSwipable();
		ButtonUnderSwipePage swipable = new ButtonUnderSwipePage(driver);
		swipable.swipeItems();
	}

	@Test(priority = 5)
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