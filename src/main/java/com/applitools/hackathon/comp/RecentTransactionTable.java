package com.applitools.hackathon.comp;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * RecentTransactionTable Component to describe & handle Recent Transactions
 * Table details.QAFWebComponent is a QAF feature to define a page component
 * which can be reused to some other application pages as well. This will bring
 * reusability in test code.
 */
public class RecentTransactionTable extends QAFWebComponent {
	/*
	 * RecentTransactionTable locators declaration. The value of the locator comes
	 * from the resources/locators/table.properties file to initialize the element.
	 * This is QAF framework locator strategy to initialize the elements.
	 */
	@FindBy(locator = "transaction.recent.th.status")
	private QAFWebElement status;

	@FindBy(locator = "transaction.recent.th.date")
	private QAFWebElement date;

	@FindBy(locator = "transaction.recent.th.description")
	private QAFWebElement desc;

	@FindBy(locator = "transaction.recent.th.category")
	private QAFWebElement category;

	@FindBy(locator = "transaction.recent.th.amount")
	private QAFWebElement amount;

	@FindBy(locator = "transaction.recent.row")
	private List<Row> transactionRow;

	/*
	 * To initilize the Component, calling parent class constructor
	 */
	protected RecentTransactionTable(String locator) {
		super(locator);
	}

	/*
	 * Getter methods to access the component elements.
	 */
	public QAFWebElement getStatus() {
		return status;
	}

	public QAFWebElement getDate() {
		return date;
	}

	public QAFWebElement getDesc() {
		return desc;
	}

	public QAFWebElement getCategory() {
		return category;
	}

	public QAFWebElement getAmount() {
		return amount;
	}

	/*
	 * getTransactionRow method will return the list of row elements.
	 */
	public List<Row> getTransactionRow() {
		return transactionRow;
	}

	/*
	 * isAmountAscending method will check whether Amount column row data is in
	 * ascending or descending order.
	 */
	public boolean isAmountAscending() {
		/*
		 * Sorting logic will come here
		 */
		// List<Row> rows = getTransactionRow();
		// for (Row row : rows) {
		//
		// }
		return true;
	}

	/*
	 * Row is a sub component of RecentTransactionTable component and this will
	 * handle each rows of the table.
	 */
	public class Row extends QAFWebComponent {
		/*
		 * Row child component locators declaration. The value of the locator comes from
		 * the resources/locators/table.properties file to initialize the element. This
		 * is QAF framework locator strategy to initialize the elements.
		 */
		@FindBy(locator = "transaction.recent.tr.status")
		private QAFWebElement status;

		@FindBy(locator = "transaction.recent.tr.date")
		private QAFWebElement date;

		@FindBy(locator = "transaction.recent.tr.description")
		private QAFWebElement desc;

		@FindBy(locator = "transaction.recent.tr.category")
		private QAFWebElement category;

		@FindBy(locator = "transaction.recent.tr.amount")
		private QAFWebElement amount;

		public Row(String locator) {
			super(locator);
		}

		/*
		 * Getter methods to access Row component elements
		 */
		public QAFWebElement getStatus() {
			return status;
		}

		public QAFWebElement getDate() {
			return date;
		}

		public QAFWebElement getDesc() {
			return desc;
		}

		public QAFWebElement getCategory() {
			return category;
		}

		public QAFWebElement getAmount() {
			return amount;
		}
	}
}