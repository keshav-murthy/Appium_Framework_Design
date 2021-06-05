package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.InitializePropertyFile;
import commons.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.QuestionnairePage;
import static commons.Configuration.appium_server_url;

public class CompleteTestCases extends TestBase {

	@BeforeMethod
	public void openPage() throws FileNotFoundException, IOException {
		
//		setUpCapabalities(InitializePropertyFile.property.getProperty("device_name"),
//				InitializePropertyFile.property.getProperty("version"),
//				InitializePropertyFile.property.getProperty("platform_name"));
//		installApp(InitializePropertyFile.property.getProperty("appium_server_url"));
//		installApp(appium_server_url.asString());
	}

	@Test(priority = 1)
	public void verifyLogin() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S1_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.verifyTest(InitializePropertyFile.property.getProperty("S01"));
	}

	@Test(priority = 2)
	public void verifyRecordsStats() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S1_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.annoateRecords();
		home.verifyTest(InitializePropertyFile.property.getProperty("S01"));
	}

	@Test(priority = 3)
	public void verifyRecordsBySpecialist02() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S2_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.specialist02Verification();
		home.verifyTest(InitializePropertyFile.property.getProperty("S02"));
	}

	@Test(priority = 4)
	public void verifyRecordsBySpecialist03() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S3_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.specialist03Verification();
		home.verifyTest(InitializePropertyFile.property.getProperty("S03"));
	}

	@Test(priority = 5)
	public void verifyRecordsBySpecialist04() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S4_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.specialist04Verification();
		home.verifyTest(InitializePropertyFile.property.getProperty("S04"));
	}

	@Test(priority = 6)
	public void verifyRecordsBySpecialist05() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("S5_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.specialist05Verification();
		home.verifyTest(InitializePropertyFile.property.getProperty("S05"));
	}

	@Test(priority = 7)
	public void verifyRecordsByManager01() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M1_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.managerValidation01();
		home.verifyTest(InitializePropertyFile.property.getProperty("M01"));
	}

	@Test(priority = 8)
	public void verifyRecordsByManager02() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M2_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.managerValidation01();
		home.verifyTest(InitializePropertyFile.property.getProperty("M02"));
	}

	@Test(priority = 9)
	public void verifyRecordsByManager03() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M3_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.managerValidation01();
		home.verifyTest(InitializePropertyFile.property.getProperty("M03"));
	}

	@Test(priority = 10)
	public void verifyRecordsByManager04() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M4_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.managerValidation01();
		home.verifyTest(InitializePropertyFile.property.getProperty("M04"));
	}
	@Test(priority = 11)
	public void verifyRecordsByManager05() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M5_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.manager05Validation();
		home.verifyTest(InitializePropertyFile.property.getProperty("M05"));
	}

	@Test(priority = 12)
	public void reVerifyRecordsByManager01() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M1_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.manager01Validation();
		home.verifyTest(InitializePropertyFile.property.getProperty("M01"));
	}

	@Test(priority = 13)
	public void reVerifyRecordsByManager02() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M2_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.manager02Validation();
		home.verifyTest(InitializePropertyFile.property.getProperty("M02"));
	}

	@Test(priority = 14)
	public void reVerifyRecordsByManager03() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M3_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.manager03Validation();
		home.verifyTest(InitializePropertyFile.property.getProperty("M03"));
	}

	@Test(priority = 15)
	public void reVerifyRecordsByManager04() {

		LoginPage login = new LoginPage(driver);
		login.loginProcess(InitializePropertyFile.property.getProperty("M4_Username"),
				InitializePropertyFile.property.getProperty("Password"));
		HomePage home = new HomePage(driver);
		home.clickOnStartWork();
		QuestionnairePage ques = new QuestionnairePage(driver);
		ques.manager04Validation();
		home.verifyTest(InitializePropertyFile.property.getProperty("M04"));
	}
}