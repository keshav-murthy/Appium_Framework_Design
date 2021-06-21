package Demo;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages2.AddOrRemovePage;
import pages2.ExpandableHeaderPage;
import pages2.HeaderPage;
import pages2.HomePage;
import pages2.MinimumHeaderPage;

public class HeaderTest extends TestBase {

	@BeforeMethod
	public void openPage() throws MalformedURLException {
		openInstalledApp("com.h6ah4i.android.example.advrecyclerview",
				"com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	}

//	@Test(priority = 1)
	public void verifyMinHeader() {

		HomePage home = new HomePage(driver);
		home.clickOnHeader();
		HeaderPage header = new HeaderPage(driver);
		header.selectHeaderMin();
		MinimumHeaderPage min = new MinimumHeaderPage(driver);
		min.verifyItems();
	}

//	@Test(priority = 2)
	public void verifyExpandableHeader() {

		HomePage home = new HomePage(driver);
		home.clickOnHeader();
		HeaderPage header = new HeaderPage(driver);
		header.selectExpandableHeader();
		ExpandableHeaderPage expand = new ExpandableHeaderPage(driver);
		expand.verifyItems();
	}

	@Test(priority = 3)
	public void verifyAddOrRemoveInHeader() {

		HomePage home = new HomePage(driver);
		home.clickOnHeader();
		HeaderPage header = new HeaderPage(driver);
		header.selectAddOrRemove();
		AddOrRemovePage add = new AddOrRemovePage(driver);
		add.verifyItems();
	}
}