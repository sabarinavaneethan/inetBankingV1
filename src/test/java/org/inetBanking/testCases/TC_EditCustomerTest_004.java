package org.inetBanking.testCases;

import java.io.IOException;

import org.inetBanking.pageObjects.EditCustomerPage;
import org.inetBanking.pageObjects.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_EditCustomerTest_004 extends BaseClass{
	
	
	@Test
	public void editCustomerTest() throws IOException, ParseException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is provided");
		
		lp.setPassWord(password);
		logger.info("Password is provided");
		
		lp.clickSubmit();
		logger.info("loginbutton is clicked");
		

		
		String custId = fileReader();
		logger.info("Customer Id is readed from json file");
		
		EditCustomerPage ep = new EditCustomerPage(driver);
		
		ep.editCustomerButton();
		logger.info("Edit customer Button is clicked");
		
		ep.passCustomerID(custId);
		logger.info("customer Id is passed on the edit customer page");
		
		
		ep.submitButton();
		logger.info("submit button is clicked");
		
		
		
		boolean contains = driver.getPageSource().contains("Edit Customer");
		
		
		if (contains==true) {
			
			logger.info("Test case is passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("Test case is failed");
			captureScreen(driver, "editCustomerTest");
			Assert.assertTrue(false);
		}

		
	}
	

}
