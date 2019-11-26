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
public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "login.header.lbl")
	private QAFWebElement header;

	@FindBy(locator = "login.biglogo.img")
	private QAFWebElement biglogoIcon;

	@FindBy(locator = "login.username.lbl")
	private QAFWebElement usernameLabel;

	@FindBy(locator = "login.password.lbl")
	private QAFWebElement passwordLabel;

	@FindBy(locator = "login.username.placeholder")
	private QAFWebElement usernamePlaceHolder;

	@FindBy(locator = "login.password.placeholder")
	private QAFWebElement passwordPlaceHolder;

	@FindBy(locator = "login.malecircle.img")
	private QAFWebElement maleCircle;

	@FindBy(locator = "login.fingerprint.img")
	private QAFWebElement fingerPrint;

	@FindBy(locator = "login.username.txt")
	private QAFWebElement username;

	@FindBy(locator = "login.password.txt")
	private QAFWebElement password;

	@FindBy(locator = "login.submit.btn")
	private QAFWebElement submit;

	@FindBy(locator = "login.rememberme.chk")
	private QAFWebElement rememberMe;

	@FindBy(locator = "login.twitter.img")
	private QAFWebElement twitterIcon;

	@FindBy(locator = "login.facebook.img")
	private QAFWebElement facebookIcon;

	@FindBy(locator = "login.linkedin.img")
	private QAFWebElement linkedinIcon;

	@FindBy(locator = "login.message.txt")
	private QAFWebElement alertMessage;

	public QAFWebElement getUsername() {
		return username;
	}

	public QAFWebElement getPassword() {
		return password;
	}

	public QAFWebElement getSubmit() {
		return submit;
	}

	public QAFWebElement getHeader() {
		return header;
	}

	public QAFWebElement getBiglogoIcon() {
		return biglogoIcon;
	}

	public QAFWebElement getMaleCircle() {
		return maleCircle;
	}

	public QAFWebElement getFingerPrint() {
		return fingerPrint;
	}

	public QAFWebElement getUsernameLabel() {
		return usernameLabel;
	}

	public QAFWebElement getPasswordLabel() {
		return passwordLabel;
	}

	public QAFWebElement getUsernamePlaceHolder() {
		return usernamePlaceHolder;
	}

	public QAFWebElement getPasswordPlaceHolder() {
		return passwordPlaceHolder;
	}

	public QAFWebElement getRememberMe() {
		return rememberMe;
	}

	public QAFWebElement getTwitterIcon() {
		return twitterIcon;
	}

	public QAFWebElement getFacebookIcon() {
		return facebookIcon;
	}

	public QAFWebElement getLinkedinIcon() {
		return linkedinIcon;
	}

	public QAFWebElement getAlertMessage() {
		return alertMessage;
	}

	public void verifyUIElements() {
		getHeader().verifyPresent();
		getBiglogoIcon().verifyPresent();

		getUsernameLabel().verifyPresent();
		getUsernamePlaceHolder().verifyPresent();

		getPasswordLabel().verifyPresent();
		getPasswordPlaceHolder().verifyPresent();

		getMaleCircle().verifyPresent();
		getFingerPrint().verifyPresent();

		getSubmit().verifyPresent();
		getRememberMe().verifyPresent();

		getTwitterIcon().verifyPresent();
		getFacebookIcon().verifyPresent();
		getLinkedinIcon().verifyPresent();
	}

	public void doLogin(String username, String password) {
		if (!username.equalsIgnoreCase("e"))
			getUsername().sendKeys(username);
		else
			getUsername().clear();

		if (!password.equalsIgnoreCase("e"))
			getPassword().sendKeys(password);
		else
			getPassword().clear();

		getSubmit().click();
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		driver.get("/");
	}
}
