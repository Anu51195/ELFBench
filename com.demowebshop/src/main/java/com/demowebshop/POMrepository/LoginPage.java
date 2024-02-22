package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base_Page {

	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id = "Email")
	private WebElement untbx;
	@FindBy(id = "Password")
	private WebElement pwtbx;
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement lgnbtn;
	
	public void login(String un,String pw) {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgnbtn.click();
	}
}
