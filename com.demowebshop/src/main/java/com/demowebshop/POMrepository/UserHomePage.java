package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHomePage extends Base_Page {
	public UserHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	private WebElement loggedInEmailIDLink;

	public String loggedInEmailID() {
		return loggedInEmailIDLink.getText();
	}
	
}
