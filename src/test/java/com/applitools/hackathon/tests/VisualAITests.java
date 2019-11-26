package com.applitools.hackathon.tests;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.hackathon.pages.ExpensesPage;
import com.applitools.hackathon.pages.LoginPage;
import com.applitools.hackathon.pages.TransactionPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class VisualAITests extends WebDriverTestCase {
	private Eyes eyes;
	/*
	 * Open the login page and write assertions to ensure everything looks OK on
	 * that page. i.e. add assertions to ensure all the fields, labels and all other
	 * items exist.
	 */
	@Test(enabled = true, priority = 1)
	public void loginUIValidationTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);
		
		eyes = new Eyes();
		eyes.setBatch(new BatchInfo("Hackathon"));
		eyes.setApiKey(ConfigurationManager.getBundle().getString("applitools.api.key"));
		eyes.open(getDriver(), "ACME Demo App", "LoginUIValidationTest");
		eyes.checkWindow();
		eyes.close();
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
	@Test(enabled = false, priority = 2)
	public void dataDrivenLoginTest(Map<String, String> testData) {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);

		loginPage.doLogin(testData.get("username"), testData.get("password"));

		if (testData.get("isValid").equalsIgnoreCase("invalid")) {// invalid check
			Validator.verifyThat(loginPage.getAlertMessage().getText(), Matchers.equalTo(testData.get("message")));
		} else {// valid check
			new TransactionPage().getShowExpensesChart().verifyPresent();
		}
	}

	/*
	 * Once logged in (use any username and password to login), view the Recent
	 * Transactions table. Your test should click on the "Amounts" header, and
	 * verify that the column is in ascending order and that each row’s data stayed
	 * in tact after the sorting.
	 */
	@Test(enabled = false, priority = 3)
	public void tableSortTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		transactionPage.getRecentTransactions().getAmount().click();
		Validator.verifyTrue(transactionPage.getRecentTransactions().isAmountAscending(),
				"Amount column data is in ascending order!", "Amount column data is in ascending order!");
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
	@Test(enabled = false, priority = 4)
	public void canvasChartTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.launchPage(null);

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		transactionPage.getShowExpensesChart().click();

		ExpensesPage expenses = new ExpensesPage();
		expenses.getCanvas().verifyPresent();
		// Validate that the bar chart and representing that data (number of bars and
		// their heights).
		// Cannot validate canvas in traditional selenium based automation
		Validator.verifyFalse(true, "Cannot validate canvas chart in traditional selenium based automation", "Success");
		expenses.getNextYear().click();
		expenses.getCanvas().verifyPresent();
		// Validate that the bar chart and representing that data (number of bars and
		// their heights).
		// Cannot validate canvas in traditional selenium based automation
		Validator.verifyFalse(true, "Cannot validate canvas chart in traditional selenium based automation", "Success");
	}

	/*
	 * Test for the existence of a display ad that’s dynamic and at times might go
	 * missing by using this URL:
	 * https://demo.applitools.com/hackathon.html?showAd=true. Log in by entering
	 * any username and password. Once logged in, you should see two different
	 * "Flash sale" gifs. Make sure both gifs exists.
	 */
	@Test(enabled = false, priority = 5)
	public void dynamicContentTest() {
		LoginPage loginPage = new LoginPage();
		getDriver().get(ConfigurationManager.getBundle().getString("env.url.showad"));

		loginPage.doLogin(ConfigurationManager.getBundle().getString("username"),
				ConfigurationManager.getBundle().getString("password"));

		TransactionPage transactionPage = new TransactionPage();
		Validator.verifyTrue(transactionPage.getFlashSale1().isDisplayed(), "Flash Sale-1 image not display",
				"Flash Sale-1 image is display");
		Validator.verifyTrue(transactionPage.getFlashSale2().isDisplayed(), "Flash Sale-2 image not display",
				"Flash Sale-2 image is display");
	}
}