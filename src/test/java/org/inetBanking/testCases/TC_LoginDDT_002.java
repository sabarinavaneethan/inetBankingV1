package org.inetBanking.testCases;

import java.io.IOException;

import org.inetBanking.pageObjects.LoginPage;
import org.inetBanking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider ="LoginData")
	public void loginDDT(String user, String password) {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("Username provided");
		
		lp.setPassWord(password);
		logger.info("Password provided");
		
		lp.clickSubmit();
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("login failed");
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() 
	{
		try {
			driver.switchTo().alert();
			return true;
			
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/org/inetBanking/testData/LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		
		int cellCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowCount-1][cellCount];
		
		for (int i = 1; i < rowCount; i++) 
		{
			for (int j = 0; j < cellCount; j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
	return logindata;	
	
	}

}
