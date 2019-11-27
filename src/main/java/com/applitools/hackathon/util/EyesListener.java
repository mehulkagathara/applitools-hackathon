package com.applitools.hackathon.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.qmetry.qaf.automation.core.ConfigurationManager;

public class EyesListener implements ITestListener {
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

	@Override
	public void onStart(ITestContext context) {
		System.out.print(">>>>>> Starting Eyes Driver <<<<<<<<<");
		String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools.api.key");
		if (null != applitoolsAPIKey) {
			Eyes e = new Eyes();
			e.setApiKey(applitoolsAPIKey);
			e.setBatch(new BatchInfo("Hackathon"));
			ConfigurationManager.getBundle().setProperty("Eyes", e);
		}
	}

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
