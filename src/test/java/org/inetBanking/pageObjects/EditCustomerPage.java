package org.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@CacheLookup
	@FindBy(xpath = "//a[text()=\"Edit Customer\"]")
	WebElement editCustomer;
	
	@CacheLookup
	@FindBy(name="cusid")
	WebElement customerID;
	
	@CacheLookup
	@FindBy(name="AccSubmit")
	WebElement submit;
	

	
	public void editCustomerButton() {
		editCustomer.click();
	}
	
	
	public void passCustomerID(String id)
	{
		customerID.sendKeys(id);
	}
	
	public void submitButton() {
		submit.click();
	}
	
}
