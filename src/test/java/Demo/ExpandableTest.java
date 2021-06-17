package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.AddOrRemovePage;
import pages2.ExpandBasicPage;
import pages2.ExpandInGroupsPage;
import pages2.ExpandMinPage;
import pages2.ExpandPage;
import pages2.HomePage;

public class ExpandableTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

//	@Test(priority = 1)
	public void verifyMinExpand() {

		HomePage home = new HomePage(driver);
		home.clickOnExpand();
		ExpandPage expand = new ExpandPage(driver);
		expand.selectExpandMin();
		ExpandMinPage min = new ExpandMinPage(driver);
		min.expandItems();
	}

//	@Test(priority = 2)
	public void verifyBasicExpand() {

		HomePage home = new HomePage(driver);
		home.clickOnExpand();
		ExpandPage expand = new ExpandPage(driver);
		expand.selectExpandBasic();
		ExpandBasicPage basic = new ExpandBasicPage(driver);
		basic.expandItems();
	}

//	@Test(priority = 3)
	public void verifyAddOrRemove() {

		HomePage home = new HomePage(driver);
		home.clickOnExpand();
		ExpandPage expand = new ExpandPage(driver);
		expand.selectAddOrRemoveItem();
		AddOrRemovePage addRem = new AddOrRemovePage(driver);
		addRem.expandItems();
	}

	@Test(priority = 4)
	public void verifyExpandInGroups() {

		HomePage home = new HomePage(driver);
		home.clickOnExpand();
		ExpandPage expand = new ExpandPage(driver);
		expand.selectExpandInGroups();
		ExpandInGroupsPage groups = new ExpandInGroupsPage(driver);
		groups.expandItems();
	}
}