package com.applitools.hackathon.pages;

import com.applitools.hackathon.comp.RecentTransactionTable;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * TransactionPage to describe & handle the Expenses page details.
 * WebDriverBaseTestPage is a QAF feature to define a POM page which can be
 * reused to write test for that specific functionality. This will bring
 * reusability in test code.
 */
public class TransactionPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	/*
	 * TransactionPage locators declaration. The value of the locator comes from the
	 * resources/locators/transaction.properties file to initialize the element.
	 * This is QAF framework locator strategy to initialize the elements.
	 */
	@FindBy(locator = "transaction.expenses.lnk")
	private QAFWebElement showExpensesChart;

	@FindBy(locator = "transaction.flashsale1.img")
	private QAFWebElement flashSale1;

	@FindBy(locator = "transaction.flashsale2.img")
	private QAFWebElement flashSale2;

	@FindBy(locator = "transaction.recent.tbl")
	private RecentTransactionTable recentTransactions;

	/*
	 * Getter methods to access page elements
	 */
	public QAFWebElement getShowExpensesChart() {
		return showExpensesChart;
	}

	public QAFWebElement getFlashSale1() {
		return flashSale1;
	}

	public QAFWebElement getFlashSale2() {
		return flashSale2;
	}

	/*
	 * RecentTransactionTable method will return Table component object and further
	 * in test can handle table operations.
	 */
	public RecentTransactionTable getRecentTransactions() {
		return recentTransactions;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
}
