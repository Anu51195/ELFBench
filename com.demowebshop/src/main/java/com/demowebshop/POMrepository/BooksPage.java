package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends Base_Page {

	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text()='Computing and Internet']/parent::h2/..//input")
	private WebElement computingandInternetAddtoCartButton;
	
	public void clickComputingAndInternetAddtoCartButton() {
		computingandInternetAddtoCartButton.click();
	}
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartLinkAfterAddingProducttoCart;
	
	public void clickBannerShoppingCartLink() {
		shoppingCartLinkAfterAddingProducttoCart.click();
	}
}
