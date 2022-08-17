package org.inetBanking.testCases;

import java.io.IOException;

import org.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("Url is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is entered");
		
		lp.setPassWord(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Login Button is clicked");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("testcase is passed");
			
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertFalse(true); 
			logger.info("testcase is failed");
		}
		
	}
	

}
