package com.applitools.hackathon.pages;

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
 * ExpensesPage to describe & handle the Expenses page details.
 * WebDriverBaseTestPage is a QAF feature to define a POM page which can be
 * reused to write test for that specific functionality. This will bring
 * reusability in test code.
 */
public class ExpensesPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	/*
	 * ExpensesPage locators declaration. The value of the locator comes from the
	 * resources/locators/expenses.properties file to initialize the element. This
	 * is QAF framework locator strategy to initialize the elements.
	 */
	@FindBy(locator = "expenses.nextyear.btn")
	private QAFWebElement nextYear;

	@FindBy(locator = "expenses.canvas.crt")
	private QAFWebElement canvas;

	/*
	 * Getter methods to access the page elements
	 */
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
