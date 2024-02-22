package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base_Page {
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	private WebElement gendermale;
	@FindBy(id = "gender-female")
	private WebElement genderfemale;
	@FindBy(id = "FirstName")
	private WebElement fntbx;
	@FindBy(id = "LastName")
	private WebElement lntbx;
	@FindBy(id = "Email")
	private WebElement emailtbx;
	@FindBy(id = "Password")
	private WebElement pw;
	@FindBy(id = "ConfirmPassword")
	private WebElement cpw;
	@FindBy(id = "register-button") 
	private WebElement rgstrbtn;
	
	/*
	 * method for Register User in demoWebshop
	 */
	public void register(String Gender,String fn,String ln,String email,String pass,String cpass) {
		if(Gender.charAt(0)=='m'||Gender.charAt(0)=='M')
			gendermale.click();
		else if (Gender.charAt(0)=='f'||Gender.charAt(0)=='F')
			genderfemale.click();
		fntbx.sendKeys(fn);
		lntbx.sendKeys(ln);
		emailtbx.sendKeys(email);
		pw.sendKeys(pass);
		cpw.sendKeys(cpass);
		rgstrbtn.click();
	}
}
