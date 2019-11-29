package com.applitools.hackathon.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.qmetry.qaf.automation.core.ConfigurationManager;

/**
 * 
 * @author mehul.kagathara
 * @company Infostretch
 */
/*
 * EyesListener listener class which implements the ITestListener TestNG
 * listener to intialize the Applitools Eyes object. This listener will handle
 * basic settings like setAPI key, batch name etc which require to initialize
 * Eyes.
 */
public class EyesListener implements ITestListener {
	/*
	 * Before test start this override method will call and set the "test_name"
	 * properties with current test. This will get use later in EyesManager class.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ConfigurationManager.getBundle().setProperty("test_name", result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	/*
	 * This overriden method will call before suite and handle Eyes operations like
	 * setAPI,batchName etc.Also, it will store Eyes object to bundle and later
	 * EyesManager will use this object. So, for every test it will not create new
	 * object of Eyes. Same object will reuse for all test and various Eyes
	 * operations.
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.print(">>>>>> Starting Eyes Driver <<<<<<<<<");
		String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools.api.key");
		if (null != applitoolsAPIKey) {
			Eyes e = new Eyes();
			e.setApiKey(applitoolsAPIKey);
			e.setBatch(new BatchInfo("Hackathon"));
			e.setForceFullPageScreenshot(true);
			e.setStitchMode(StitchMode.CSS);
			ConfigurationManager.getBundle().setProperty("Eyes", e);
		}
	}

	/*
	 * This method will call at the end of the execution and release Eyes resources.
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.print(">>>>>> END <<<<<<<<<\n");
		String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools_key");
		if (null != applitoolsAPIKey) {
			Eyes e = (Eyes) ConfigurationManager.getBundle().getObject("Eyes");
			TestResults close = e.close();
			// Add validator
			System.out.println(">>>>>> Applitools report URL: " + close.getUrl());
		}
	}
}
