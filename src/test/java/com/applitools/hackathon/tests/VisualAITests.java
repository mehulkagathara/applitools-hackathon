package com.applitools.hackathon.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.applitools.eyes.MatchLevel;
import com.applitools.hackathon.pages.ExpensesPage;
import com.applitools.hackathon.pages.LoginPage;
import com.applitools.hackathon.pages.TransactionPage;
import com.applitools.hackathon.util.EyesBaseTestCase;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * VisualAITests class which extends the QAF base class EyesBaseTestCase to get
 * all basic framework & Eyes features. This test class is to demonstrate the
 * Applitools Visual AI capabilities to simplify automation using AI.
 */
public class VisualAITests extends EyesBaseTestCase {
	/*
	 * Open the login page and write assertions to ensure everything looks OK on
	 * that page. i.e. add assertions to ensure all the fields, labels and all other
	 * items exist.
	 */
	@Test(enabled = true, priority = 1)
	public void loginUIValidationTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		/*
		 * By default MatchLevel is STRICT only, to just demonstrate purpose how to set
		 * new MatchLevel at test level adding this line.In case, if you would like to
		 * set different level.
		 */
		getEyesManager().setMatchLevel(MatchLevel.STRICT);
		/*
		 * Validate the UI by simply calling checkWindow method instead of writting
		 * locators and other selenium code.
		 */
		getEyesManager().checkWindow();
	}

	/*
	 * Test the following login functionality by entering different values to
	 * username and password fields. If you don’t enter the username and password
	 * and click the login button, it should throw an error If you only enter the
	 * username and click the login button, it should throw an error If you only
	 * enter the password and click the login button, it should throw an error If
	 * you enter both username (any value) and password (any value), it should log
	 * you in.
	 */
	@QAFDataProvider(dataFile = "resources/data/login.xml", key = "login.data")
	@Test(enabled = true, priority = 2)
	public void dataDrivenLoginTest(Map<String, String> testData) {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		/*
		 * doLogin method will login with given username and password. data will come
		 * from data provider and it will fetch from login.xml file. @QAFDataProvider is
		 * framework feature to get the external data to test.
		 */
		loginPage.doLogin(testData.get("username"), testData.get("password"));
		/*
		 * By default MatchLevel is STRICT only, to just demonstrate purpose how to set
		 * new MatchLevel at test level adding this line.In case, if you would like to
		 * set different level.
		 */
		getEyesManager().setMatchLevel(MatchLevel.STRICT);
		/*
		 * Validate the UI by simply calling checkWindow method instead of writting
		 * locators and other selenium code. Since this is data driven test, passing
		 * optional argument to sufix iteration details and this will add to test name.
		 * So in report user can easily see checkWindow result for each iteration of
		 * test.
		 */
		getEyesManager().checkWindow(testData.get("recId"));
	}

	/*
	 * Once logged in (use any username and password to login), view the Recent
	 * Transactions table. Your test should click on the "Amounts" header, and
	 * verify that the column is in ascending order and that each row’s data stayed
	 * in tact after the sorting.
	 */
	@Test(enabled = true, priority = 3)
	public void tableSortTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		/*
		 * Standard valid test data defined in resources/data/user.properties.
		 */
		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		/*
		 * Clicking on Amount column header to get data sort based on amount.
		 */
		transactionPage.getRecentTransactions().getAmount().click();
		QAFTestBase.pause(2000);
		/*
		 * Set Content level to validate the table content
		 */
		getEyesManager().setMatchLevel(MatchLevel.CONTENT);
		/*
		 * Validate the UI by simply calling checkWindow method instead of writting
		 * locators and other selenium code.
		 */
		getEyesManager().checkWindow();
	}

	/*
	 * Once logged in, click on the "Compare Expenses" button on the toolbar. This
	 * will display a bar chart comparing the expenses for the year 2017 and 2018.
	 * Assume the values of the chart are coming from a test data and the test data
	 * will not change across versions. Validate that the bar chart and representing
	 * that data (number of bars and their heights). They should remain the same
	 * across versions. Then click on the "Show data for next year" button. This
	 * should add the data for the year 2019. Verify that this data set is added for
	 * the year 2019
	 */
	@Test(enabled = true, priority = 4)
	public void canvasChartTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		/*
		 * Standard valid test data defined in resources/data/user.properties.
		 */
		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		transactionPage.getShowExpensesChart().click();
		/*
		 * By default MatchLevel is STRICT only, to just demonstrate purpose how to set
		 * new MatchLevel at test level adding this line.In case, if you would like to
		 * set different level.
		 */
		getEyesManager().setMatchLevel(MatchLevel.STRICT);

		ExpensesPage expenses = new ExpensesPage();
		/*
		 * Validate the UI by simply calling checkWindow method instead of writting
		 * locators and other selenium code. First it will check window for 2017-18 data
		 * display in canvas. Passing optional checkWindow argument to append suffix to
		 * test name. So, in applitools dashboard report it will show separate.
		 */
		getEyesManager().checkWindow("(2017-18)");

		expenses.getNextYear().click();
		/*
		 * for 2019-19 data
		 */
		getEyesManager().checkWindow("(2018-19)");
	}

	/*
	 * Test for the existence of a display ad that’s dynamic and at times might go
	 * missing by using this URL:
	 * https://demo.applitools.com/hackathon.html?showAd=true. Log in by entering
	 * any username and password. Once logged in, you should see two different
	 * "Flash sale" gifs. Make sure both gifs exists.
	 */
	@Test(enabled = true, priority = 5)
	public void dynamicContentTest() {
		LoginPage loginPage = new LoginPage();
		/*
		 * Navigate to showad url and url will fetch from the respective enviornment
		 * properties file. example, resources/env1 or resources/env2.
		 */
		getDriver().get(ConfigurationManager.getBundle().getString("env.url.showad"));
		/*
		 * Standard valid test data defined in resources/data/user.properties.
		 */
		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));
		/*
		 * By default MatchLevel is STRICT only, to just demonstrate purpose how to set
		 * new MatchLevel at test level adding this line.In case, if you would like to
		 * set different level.
		 */
		getEyesManager().setMatchLevel(MatchLevel.STRICT);
		/*
		 * Validate the UI by simply calling checkWindow method instead of writting
		 * locators and other selenium code.
		 */
		getEyesManager().checkWindow();
	}
}