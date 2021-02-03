package com.freecrm.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.baseclass.TestBase;
import com.freecrm.util.TestUtil;

public class SignUpPage extends TestBase
{
	TestUtil testUtil;
	

	@FindBy(xpath="//h2[contains(text(),'Register')]")
	WebElement registerLogo;
	
	@FindBy(xpath="//div[@class='active step']")
	WebElement enterYourDetails;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	
	@FindBy(xpath="//input[@class='search']")
	WebElement countryCodeOption;
	
	@FindBy(xpath="//div[@class='menu transition visible']")
	WebElement menu;
	
	
	@FindBy(xpath="//input[@id='phone_number']")
	WebElement phoneNum;
	
	
	
	@FindBy(xpath="//input[@id='terms']")
	WebElement iAgreeCheckBox;
	
	

	
	public  SignUpPage()
	{
		PageFactory.initElements(driver, this);
		testUtil=new TestUtil();
		
	}
	
	public boolean verifyRegisterLogo()
	{
		return registerLogo.isDisplayed();
	}
	
	
	public boolean verifyEnterYourDetails()
	{
		return enterYourDetails.isEnabled();
	}
	
	public void signUp(String mail)
	{
		email.sendKeys(mail);
		
		countryCodeOption.click();
	//	testUtil.displayed(driver, menu, 10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> menuOptions=driver.findElements(By.xpath("//div[@class='menu transition visible']"));
		
		for(WebElement e :menuOptions)
		{
			
			if(e.getText().equals("India (+91)"))
			{
				e.click();
				break;
			}
			
		}
		phoneNum.sendKeys("1000000000");
		if(!iAgreeCheckBox.isSelected())
		{
			iAgreeCheckBox.click();
		}
		
	
		
		
		
		
	}
	
	
	
}
