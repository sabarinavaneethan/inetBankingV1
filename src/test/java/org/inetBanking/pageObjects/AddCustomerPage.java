package org.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath = "//div[@id=\"dismiss-button\"]")
	WebElement exitButton;
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	WebElement customerAdd;
	
	@FindBy(how=How.NAME,using = "name")
	WebElement CustomerName;
	
	@FindBy(how = How.NAME, using ="rad1")
	WebElement gender;
	
	@FindBy(how = How.NAME, using ="dob")
	WebElement dob;

	@FindBy(how = How.NAME, using ="addr")
	WebElement address;
	
	@FindBy(how = How.NAME, using ="city")
	WebElement city;
	
	@FindBy(how = How.NAME, using ="state")
	WebElement state;
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement pinNo;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	WebElement telephoneno;
	
	@FindBy(how = How.NAME, using ="emailid")
	WebElement emailid;
	
	@FindBy(how = How.NAME, using ="password")
	WebElement password; 
	
	@FindBy(how=How.NAME,using="sub")
	WebElement submitButton;
	
	
	@FindBy(how=How.XPATH,using="(//table[@id=\"customer\"]//td)[5]")
	WebElement customerId;
	
	public void exitButton() {
		exitButton.click();
	}
	
	public void newCustomerAdd() {
		customerAdd.click();
	}
	
	public void customerName(String name) {
		CustomerName.sendKeys(name);
	}
	
	public void Gender() {
		gender.click();
	}
	
	public void dateOfBirth(String dd,String mm,String yy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	}
	
	public void address(String add) {
		address.sendKeys(add);
	}
	
	public void city(String c) {
		city.sendKeys(c);

	}
	
	public void state(String st) {
		
		state.sendKeys(st);
		
	}
	
	public void pinNo(String pin) {
		pinNo.sendKeys(pin);
	}
	
	
	public void phoneNo(String no) {
		
		telephoneno.sendKeys(no);
	}
	
	
	public void emailId(String em) {
		emailid.sendKeys(em);
	}
	
	
	public void password(String pass) {
		password.sendKeys(pass);
	}
	
	
	public void submitButton() {
		submitButton.click();
	}
	
	public String getcustomerId() {
		String text = customerId.getText();
		return text;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
