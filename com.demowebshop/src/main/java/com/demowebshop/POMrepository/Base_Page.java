package com.demowebshop.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {

	public Base_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
