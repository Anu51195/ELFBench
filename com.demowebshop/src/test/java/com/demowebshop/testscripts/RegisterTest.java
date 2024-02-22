package com.demowebshop.testscripts;
import org.testng.annotations.Test;

import com.demowebshop.POMrepository.RegisterPage;
import com.demowebshop.POMrepository.UserHomePage;
import com.demowebshop.POMrepository.WelcomePage;
import com.demowebshop.genericlibrary.Base_Test;

public class RegisterTest extends Base_Test{

	@Test
	public void TC_Register_001() {
	WelcomePage welcomePage = new WelcomePage(driver);
	welcomePage.registerClick();
	RegisterPage registerPage = new RegisterPage(driver);
		registerPage.register("m", "Anurag", "Dixit", "Hellooo@hahahehe.com", "Password@123", "Password@123");
	
	UserHomePage homePage = new UserHomePage(driver);
	softAssert.assertEquals("Hellooo@hahahehe.com", homePage.loggedInEmailID());
	}
}
