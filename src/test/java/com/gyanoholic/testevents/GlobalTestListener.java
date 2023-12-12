package com.gyanoholic.testevents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GlobalTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On START TEST METHOD TRIGGERED!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On SUCCESS METHOD TRIGGERED!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On FAILURE METHOD TRIGGERED!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On START METHOD TRIGGERED!");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On FINISH METHOD TRIGGERED!");
	}

}
