package com.demowebshop.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.POMrepository.BooksPage;
import com.demowebshop.POMrepository.LoginPage;
import com.demowebshop.POMrepository.ShoppingCartPage;
import com.demowebshop.POMrepository.UserHomePage;
import com.demowebshop.POMrepository.WelcomePage;
import com.demowebshop.genericlibrary.Base_Test;

public class AddToCartTest extends Base_Test {

	@Test
	public void TC_AddToCart001() {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickloginlink();
		test.log(Status.INFO, "Login page is displayed");
		LoginPage lp = new LoginPage(driver);
		lp.login("Hellooo@hahahehe.com", "Password@123");
		try {
			UserHomePage userHomePage = new UserHomePage(driver);
			if(userHomePage.loggedInEmailID().equals("Hellooo@hahahehe.com"));
			test.log(Status.PASS, "Login Successful");
		}catch (Exception e) {
			test.log(Status.FAIL, "Login Unsuccessful");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreeenshotofPage(driver)).build());
			Reporter.log("User not Logged in");
		}
		welcomePage.ClickBookLink();
		BooksPage bookspage=new BooksPage(driver);
		try {
		bookspage.clickComputingAndInternetAddtoCartButton();
		bookspage.clickBannerShoppingCartLink();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		System.out.println(shoppingCartPage.getShoppigCartFirstRowProductName().getText());
		softAssert.assertEquals(shoppingCartPage.getShoppigCartFirstRowProductName().
				getText(), "Computing and Internet");
		}catch (Exception e) {
			test.log(Status.FAIL, "Failed");
		}
	}
}
