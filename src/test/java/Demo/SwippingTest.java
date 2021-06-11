package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.HomePage;
import pages2.SwipableBasicPage;
import pages2.SwipableMinPage;
import pages2.SwipePage;

public class SwippingTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

//	@Test(priority=1)
	public void verifySwipeMin() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.selectSwipableMin();
		SwipableMinPage swipable = new SwipableMinPage(driver);
		swipable.swipeItems();
	}
	
	@Test(priority=2)
	public void verifySwipeBasic() {

		HomePage home = new HomePage(driver);
		home.clickOnSwipe();
		SwipePage swipe = new SwipePage(driver);
		swipe.selectSwipableBasic();
		SwipableBasicPage swipable = new SwipableBasicPage(driver);
		swipable.swipeItems();
	}
}