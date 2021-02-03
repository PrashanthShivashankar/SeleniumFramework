package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.baseclass.TestBase;
import com.freecrm.pages.LoginPage;
import com.freecrm.pages.SignUpPage;

public class SignUpPageTestCases extends TestBase
{

	public static LoginPage loginPage;
	public static  SignUpPage signUpPage;
	
	public SignUpPageTestCases()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		signUpPage=loginPage.signUpButton();
		
	}
	
	@Test(priority=1)
	public void testRegisterLogo()
	{
		Assert.assertTrue(signUpPage.verifyRegisterLogo());
	}
	@Test(priority=2)
	public void testEnterYourDetails()
	{
		Assert.assertTrue(signUpPage.verifyEnterYourDetails());
	}
	
	@Test(priority=3)
	public void signUp()
	{
		signUpPage.signUp("Prash@gmail.com");
	}
	
	@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
