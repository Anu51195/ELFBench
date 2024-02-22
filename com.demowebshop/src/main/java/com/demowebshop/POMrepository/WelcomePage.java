package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends Base_Page {
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(partialLinkText = "BOOKS")
	private WebElement BooksLink;
	@FindBy(partialLinkText = "Log in")
	private WebElement loginlink;
	@FindBy(partialLinkText = "Register")
	private WebElement registerLink;
	
	public void clickloginlink() {
		loginlink.click();
	}
	public void registerClick() {
		registerLink.click();
	}
	public void ClickBookLink() {
		BooksLink.click();
	}
	
}
