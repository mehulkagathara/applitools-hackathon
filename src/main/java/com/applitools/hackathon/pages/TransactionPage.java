package com.applitools.hackathon.pages;

import com.applitools.hackathon.comp.RecentTransactionTable;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class TransactionPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "transaction.expenses.lnk")
	private QAFWebElement showExpensesChart;

	@FindBy(locator = "transaction.flashsale1.img")
	private QAFWebElement flashSale1;

	@FindBy(locator = "transaction.flashsale2.img")
	private QAFWebElement flashSale2;

	@FindBy(locator = "transaction.recent.tbl")
	private RecentTransactionTable recentTransactions;

	public QAFWebElement getShowExpensesChart() {
		return showExpensesChart;
	}

	public QAFWebElement getFlashSale1() {
		return flashSale1;
	}

	public QAFWebElement getFlashSale2() {
		return flashSale2;
	}

	public RecentTransactionTable getRecentTransactions() {
		return recentTransactions;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
}
