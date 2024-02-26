package com.demowebshop.genericlibrary;

import java.io.IOException;
import java.time.Duration;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test extends FrameworkLibrary {
	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	public void browserSetup(Method method) throws IOException {
		testMethodName=method.getName();
		test = reports.createTest(testMethodName);
		if(getPropertyValue("browser").equals("chrome")){
				driver = new ChromeDriver();
		}else if(getPropertyValue("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com");
		initObjects(driver);	
		test.log(Status.INFO, "Browser is launched and url is navigated");
	}
	@AfterMethod(alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
		softAssert.assertAll();
	}
	@BeforeSuite
	 public void reportConfig() {
		sparkReporter=new ExtentSparkReporter(EXTENT_PATH+name());
		
	}
	@AfterSuite
	public void reportFlush() {
		reports.flush();
	}
	@BeforeClass
	public void reportstart() {
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
	}
	
}
	