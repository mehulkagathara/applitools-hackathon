package com.applitools.hackathon.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.applitools.eyes.MatchLevel;
import com.applitools.hackathon.pages.ExpensesPage;
import com.applitools.hackathon.pages.LoginPage;
import com.applitools.hackathon.pages.TransactionPage;
import com.applitools.hackathon.util.EyesManager;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class VisualAITests extends WebDriverTestCase {
	/*
	 * Open the login page and write assertions to ensure everything looks OK on
	 * that page. i.e. add assertions to ensure all the fields, labels and all other
	 * items exist.
	 */
	@Test(enabled = true, priority = 1)
	public void loginUIValidationTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		EyesManager eyesManager = new EyesManager(getDriver());
		eyesManager.setMatchLevel(MatchLevel.STRICT);
		eyesManager.checkWindow();
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

		loginPage.doLogin(testData.get("username"), testData.get("password"));

		EyesManager eyesManager = new EyesManager(getDriver());
		eyesManager.setMatchLevel(MatchLevel.STRICT);
		eyesManager.checkWindow(testData.get("recId"));
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

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		transactionPage.getRecentTransactions().getAmount().click();
		
		EyesManager eyesManager = new EyesManager(getDriver());
		eyesManager.setMatchLevel(MatchLevel.CONTENT);
		eyesManager.checkWindow();
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

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		transactionPage.getShowExpensesChart().click();
		
		EyesManager eyesManager = new EyesManager(getDriver());
		eyesManager.setMatchLevel(MatchLevel.STRICT);
		
		ExpensesPage expenses = new ExpensesPage();
		eyesManager.checkWindow("(2017-18)");
		
		expenses.getNextYear().click();
		
		eyesManager.checkWindow("(2018-19)");
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
		getDriver().get(ConfigurationManager.getBundle().getString("env.url.showad"));

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		EyesManager eyesManager = new EyesManager(getDriver());
		eyesManager.setMatchLevel(MatchLevel.STRICT);
		
		eyesManager.checkWindow();
	}
}