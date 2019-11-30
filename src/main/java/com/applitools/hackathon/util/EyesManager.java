package com.applitools.hackathon.util;

import org.apache.commons.lang.StringUtils;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * EyesManager class to perform common Eyes operations like checkWindows etc.
 * This will take WebDriver object in argument to initialize the class.
 */
public class EyesManager {
	private Eyes eyes;
	private final String appName = "ACME";
	private QAFWebDriver driver;

	/*
	 * Contructor will take WebDriver to initialize Eyes object.
	 */
	public EyesManager(QAFWebDriver driver) {
		this.eyes = (Eyes) ConfigurationManager.getBundle().getObject("Eyes");
		this.driver = driver;
	}

	/*
	 * checkWindow method to check the windows using Visual AI and also take suffix
	 * as argument to show appropriate test name in Applitools dashboard. Scope will
	 * be entire page.
	 */
	public void checkWindow(String... testSufix) {
		String testName = StringUtils.capitalize(ConfigurationManager.getBundle().getString("test_name"));
		if (!eyes.getIsOpen()) {
			if (testSufix.length > 0) {
				eyes.open(driver, appName, testName + (String) testSufix[0]);
			} else {
				eyes.open(driver, appName, testName);
			}
			eyes.checkWindow();
			eyes.closeAsync();
		}
	}

	/*
	 * checkElement method to check the element using Visual AI and also take suffix
	 * as argument to show appropriate test name in Applitools dashboard. Scope will
	 * be limited to given Element.
	 */
	public void checkElement(String locator, String... testSufix) {
		String testName = StringUtils.capitalize(ConfigurationManager.getBundle().getString("test_name"));
		if (!eyes.getIsOpen()) {
			if (testSufix.length > 0) {
				eyes.open(driver, appName, testName + (String) testSufix[0]);
			} else {
				eyes.open(driver, appName, testName);
			}
			/*
			 * Create a new WebElement based on given locator key. This capability is
			 * derived from framework.
			 */
			QAFExtendedWebElement el = new QAFExtendedWebElement(locator);
			eyes.checkElement(el);
			eyes.closeAsync();
		}
	}

	/*
	 * setTakeFullScreenshot - boolean method to take full page screenshot
	 */
	public void setTakeFullScreenshot(boolean shouldForce) {
		eyes.setForceFullPageScreenshot(shouldForce);
		eyes.setStitchMode(StitchMode.CSS);
	}

	/*
	 * setMatchLevel method to set match level
	 */
	public void setMatchLevel(MatchLevel level) {
		eyes.setMatchLevel(level);
	}
}
