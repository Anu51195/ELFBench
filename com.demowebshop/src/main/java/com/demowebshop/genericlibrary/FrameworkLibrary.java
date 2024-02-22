package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FrameworkLibrary implements FrameworkConstants {

	public Actions action;
	public WebDriverWait wait;
	public SoftAssert softAssert;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;
	public String testMethodName;
	
	public void Select(WebElement dropdown, String options) {
		Select s = new Select(dropdown);
		int counter = 0;
		try {
			int indexvalue=Integer.parseInt(options);
			s.selectByIndex(indexvalue);
			counter++;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not a index value");
		}
		if(counter==0) {
			try {
				s.selectByValue(options);
			}catch (Exception e) {
				s.selectByVisibleText(options);
			}
		}
	}
	
	public String takeScreeenshotofPage(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String filePath = SCREENSHOT_PATH+name()+".png";
		File dest = new File(filePath);
		File temp = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+filePath;
	}
	public void takeScreeenshotofElement(WebElement ele) {
		File dest = new File(SCREENSHOT_PATH+name()+".png");
		File temp = ele.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String name() {

		LocalDateTime dateTime=LocalDateTime.now();
		String fileName = dateTime.toString().replace(":", "-");
		return fileName;
	}
	public String getPropertyValue(String Key) throws IOException {
		File file = new File(PROPERTIES_PATH);
		FileInputStream fis = new FileInputStream(file);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(Key);
	}
	public void initObjects(WebDriver driver) {
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		softAssert = new SoftAssert();
	}
	public void scrollActionTillWebElement(WebElement element) {
		action.scrollToElement(element).build();
	}
}
