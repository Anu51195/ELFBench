package com.demowebshop.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.POMrepository.LoginPage;
import com.demowebshop.POMrepository.UserHomePage;
import com.demowebshop.POMrepository.WelcomePage;
import com.demowebshop.genericlibrary.Base_Test;
import com.demowebshop.genericlibrary.ExcelRead;

public class LoginTest extends Base_Test {
	@Test(dataProvider = "loginData")
	public void TC_Login001(String un, String pw) throws InterruptedException {
		WelcomePage wp = new  WelcomePage(driver);
		wp.clickloginlink();
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		UserHomePage uhp = new UserHomePage(driver);
		softAssert.assertEquals(un, uhp.loggedInEmailID());
	}
	
	@DataProvider(name = "loginData")
	public String[][] loginData() throws EncryptedDocumentException, IOException{
		String [][] data = ExcelRead.multipleRead("Login");
		return data; 
	}
}
