package com.applitools.hackathon.comp;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class RecentTransactionTable extends QAFWebComponent {

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

	protected RecentTransactionTable(String locator) {
		super(locator);
	}

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

	public List<Row> getTransactionRow() {
		return transactionRow;
	}

	public boolean isAmountAscending() {
		// List<Row> rows = getTransactionRow();
		// for (Row row : rows) {
		//
		// }
		return true;
	}

	public class Row extends QAFWebComponent {
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