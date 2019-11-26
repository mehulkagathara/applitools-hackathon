package com.applitools.hackathon.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class ExpensesPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "expenses.nextyear.btn")
	private QAFWebElement nextYear;

	@FindBy(locator = "expenses.canvas.crt")
	private QAFWebElement canvas;

	public QAFWebElement getNextYear() {
		return nextYear;
	}

	public QAFWebElement getCanvas() {
		return canvas;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
}
