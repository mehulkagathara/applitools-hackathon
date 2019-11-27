package com.applitools.hackathon.util;

import com.applitools.eyes.selenium.Eyes;
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

	public void checkWindow(QAFWebDriver driver) {
		if (!eyes.getIsOpen()) {
			eyes.open(driver, appName, ConfigurationManager.getBundle().getString("test_name"));
			eyes.checkWindow();
			eyes.close();
		}
	}
}
