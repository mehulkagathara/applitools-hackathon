package com.applitools.hackathon.util;

import org.apache.commons.lang.StringUtils;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class EyesManager {
	private Eyes eyes;
	private final String appName = "ACME Demo";

	public EyesManager() {
		this.eyes = (Eyes) ConfigurationManager.getBundle().getObject("Eyes");
	}

	public void checkWindow(QAFWebDriver driver, String... testSufix) {
		String testName = StringUtils.capitalize(ConfigurationManager.getBundle().getString("test_name"));
		if (!eyes.getIsOpen()) {
			if (testSufix.length > 0) {
				eyes.open(driver, appName, testName + (String) testSufix[0]);
			} else {
				eyes.open(driver, appName, testName);
			}
			eyes.checkWindow();
			eyes.close();
		}
	}

	public void takeFullScreenshot(boolean shouldForce) {
		eyes.setForceFullPageScreenshot(shouldForce);
		eyes.setStitchMode(StitchMode.CSS);
	}
	public void setMatchLevel(MatchLevel level) {
		eyes.setMatchLevel(level);
	}
}
