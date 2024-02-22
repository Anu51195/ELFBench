package com.demowebshop.genericlibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplemantation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finish");
	}
}
