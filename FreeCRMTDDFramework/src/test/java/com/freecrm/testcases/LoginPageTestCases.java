package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.baseclass.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.pages.SignUpPage;

public class LoginPageTestCases extends TestBase
{

	public HomePage homePage;
	public SignUpPage signUpPage;
	public LoginPage loginPage;
	
	public LoginPageTestCases()
	{
		super();
			
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		signUpPage=new SignUpPage();
		homePage=new HomePage();
		
	}
	
	@Test(priority=1)
	public void testLogo()
	{
		Assert.assertTrue(loginPage.testLogo());
	}
	
	@Test(priority=2)
	public void testHomeButton()
	{
		Assert.assertTrue(loginPage.homebutton());
	}
	@Test(priority=3)
	public void testPricingButton()
	{
		Assert.assertTrue(loginPage.pricingButton());
	}
	
	@Test(priority=4)
	public void testfeaturesButton()
	{
		Assert.assertTrue(loginPage.pricingButton());
	}
	@Test(priority=5)
	public void testCustomersButton()
	{
		Assert.assertTrue(loginPage.customerButton());
	}
	@Test(priority=6)
	public void testContactsButton()
	{
		Assert.assertTrue(loginPage.cobtactButton());
	}
	
	@Test(priority=7)
	public void testSignUpButton()
	{
		signUpPage=loginPage.signUpButton();
	}
	@Test(priority=8)
	public void testLogin()
	{
		homePage=loginPage.login();
	}
	
	@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	
	
	
	
}
