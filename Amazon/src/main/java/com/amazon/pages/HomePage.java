package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBaseClass;

public class HomePage extends TestBaseClass
{

	//OR- Page Factory of Homapage-- Define all the webElements here
	
	/* @FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@findby(xpath=".......")
	WebElement loginbtn;  */
	
	
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchField;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	WebElement searchBtn;
	
	//initialize the page factory elements inside a method
	
	
	public HomePage()
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String getTitle()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public SignUpPage searchFunction(String vlaue)
	{
		searchField.sendKeys(vlaue);
		searchBtn.click();
		
		return new SignUpPage();
	}
	
	
	
	
}
