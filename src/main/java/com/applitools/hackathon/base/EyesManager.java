package com.applitools.hackathon.base;

import com.applitools.eyes.selenium.Eyes;
import com.qmetry.qaf.automation.core.ConfigurationManager;

/*
 * Author: Mehul Kagathara
 * Company: Infostretch
 */
public class EyesManager {
	private Eyes eyes;

	public Eyes getEyes() {
		return eyes;
	}

	public EyesManager() {
		eyes.setApiKey(ConfigurationManager.getBundle().getString("applitools.api.key"));
	}
}
