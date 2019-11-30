package com.applitools.hackathon.util;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * EyesBaseTestCase class which extends the QAF base class WebDriverTestCase to
 * get all basic framework features.
 */
public class EyesBaseTestCase extends WebDriverTestCase {
	private EyesManager eyesManager;

	public EyesBaseTestCase() {
		super();
	}

	/*
	 * getEyesManager method will check if eyes created or not, if it is created
	 * then return eyes to test class which extends EyesBaseTestCase class otherwise
	 * first it will create new instance and then return.
	 */
	protected EyesManager getEyesManager() {
		if (eyesManager == null) {
			eyesManager = new EyesManager(getDriver());
		}
		return eyesManager;
	}
}
