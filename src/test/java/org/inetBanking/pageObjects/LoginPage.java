package org.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) 
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@CacheLookup
	@FindBy(name="uid")
	WebElement userName;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement passWord;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@CacheLookup
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutButton;
	
	
	
	public void setUserName(String uname) 
	{
		userName.sendKeys(uname);
	}
	
	public void setPassWord(String pass)
	{
		passWord.sendKeys(pass);
	}
	
	public void clickSubmit() {
		
		loginButton.click();
	}
	
	public void clickLogOut() {
		
		logoutButton.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
