package com.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseListener;

public class LoginControllerListener extends BaseListener implements ITestListener {

	private static final Logger LOG = LogManager.getLogger(LoginControllerListener.class);
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure----------");
		FailedScreenshot(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess----------");
		SucessScreenshot(result.getName());
	}
	
}
