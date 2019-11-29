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
 * LoginPage to describe & handle the Expenses page details.
 * WebDriverBaseTestPage is a QAF feature to define a POM page which can be
 * reused to write test for that specific functionality. This will bring
 * reusability in test code.
 */
public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	/*
	 * LoginPage locators declaration. The value of the locator comes from the
	 * resources/locators/login.properties file to initialize the element. This is
	 * QAF framework locator strategy to initialize the elements.
	 */
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

	/*
	 * Getter methods to access elements
	 */
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

	/*
	 * verifyUIElements method is to validate all UI aspects of the Login page.
	 * verifyPresent() is QAF inbuilt element soft assert method to check if element
	 * is present on screen or not.
	 */
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

	/*
	 * doLogin method will do the login to application with given username and
	 * password. If value of username or password is "e" that means empty and it
	 * will not enter any text to field.
	 */
	public void doLogin(String username, String password) {
		// handle condition to check if username input value is not empty then enter
		// text
		if (!username.equalsIgnoreCase("e"))
			getUsername().sendKeys(username);
		else // clear field
			getUsername().clear();
		// handle condition to check if password input value is not empty then enter
		// text
		if (!password.equalsIgnoreCase("e"))
			getPassword().sendKeys(password);
		else// clear field
			getPassword().clear();
		// click on Login button
		getSubmit().click();
	}

	/*
	 * Will call this method when we initiate the object of LoginPage class and
	 * launch the application url from loaded resources."/" means it will batch url
	 * from env.baseurl properties value and it is declared under
	 * resources/env1/env.properties.
	 */
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		driver.get("/");
	}
}
