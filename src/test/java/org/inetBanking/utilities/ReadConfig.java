package org.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro = new Properties();;
	
	public ReadConfig() {
		
		File src= new File("./Configuration/config.properties");		
		
		try {
			
			FileInputStream fin = new FileInputStream(src);
			
			pro.load(fin);
			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
		
	}
	
	
	
	public String getApplicationURL() {
		
		String url = pro.getProperty("baseUrl");
		
		return url;

	}
	
	public String getLoginUserName() {

		String username = pro.getProperty("username");
		return username;

	}
	
	public String getLoginPassWord() {
	
		String password = pro.getProperty("password");
		return password;
		
	}
	
	public String getCustomerName() {
		String customerID = pro.getProperty("customerName");
		return customerID;
	}
	
	
	

}
