package com.freecrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.baseclass.TestBase;


public class LoginPage extends TestBase
{

	//First Need to create page factory
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homebtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	

	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricingBtn;
	

	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement fetureBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement customerBtn;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement cobtactBtn;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	

	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginbtn;
	
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean testLogo()
	{
		boolean logoresult=logo.isDisplayed();
		return logoresult;
		
	}
	public boolean homebutton()
	{
		boolean homeBtn=homebtn.isDisplayed();
		return homeBtn;
		
	}
	public SignUpPage signUpButton()
	{
		System.out.println(signUpBtn.isDisplayed());
		signUpBtn.click();
		return new SignUpPage();
		
	}
	
	public boolean pricingButton()
	{
		return pricingBtn.isDisplayed();
	}
	
	public boolean fetureButton()
	{
		return fetureBtn.isDisplayed();
	}
	public boolean customerButton()
	{
		return customerBtn.isDisplayed();
	}
	
	public boolean cobtactButton()
	{
		return cobtactBtn.isDisplayed();
	}
	
	public String getTitleOfThePage()
	{
		return driver.getTitle();
	}
	
	public HomePage login()
	{
		userName.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",loginbtn );
		return new HomePage();
		
	}
	
	
	
}
