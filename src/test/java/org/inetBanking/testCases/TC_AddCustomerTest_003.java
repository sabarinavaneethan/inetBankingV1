package org.inetBanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.inetBanking.pageObjects.AddCustomerPage;
import org.inetBanking.pageObjects.LoginPage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		
		
		lp.setUserName(username);
		logger.info("Username provided");
		
		lp.setPassWord(password);
		logger.info("Password provided");
		lp.clickSubmit();
		
		AddCustomerPage cp = new AddCustomerPage(driver);
		
		logger.info("Customer details provided....");
		cp.newCustomerAdd();

		//String customerN = randomStringGenerator(6);
		cp.customerName(customername);
		cp.Gender();
		cp.dateOfBirth("01","11","1998");
		cp.address("Madurai Simmakkal");
		cp.city("Madurai");
		cp.state("Tamilnadu");
		cp.pinNo("625001");
		
		String phoneNo = randomNumberGenerator(10);
		cp.phoneNo(phoneNo);
		
		String s =randomStringGenerator(5);
		String email=s+"@gmail.com";
		cp.emailId(email);
		
		
		String password = randomNumberGenerator(7);
		cp.password(password);
		
		cp.submitButton();
		
		String getcustomerId = cp.getcustomerId();
		
		jsonObject.put("customerID", getcustomerId);
		filewriter(jsonObject);

		logger.info("Verifing whether the Customer is add Successfully.....");
		
		
		boolean contains = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (contains==true) 
		{
			logger.info("TestCase is passed");
			Assert.assertTrue(true);	

		}
		
		else
		{
			logger.info("Testcase is failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
