package com.amazon.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBaseClass;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignUpPage;

public class HomePageTest extends TestBaseClass
{

	HomePage homepage;
	SignUpPage signUp;
	
	public HomePageTest()
	{
		super(); // to call TestBaseCalss constructor
		
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		homepage=new HomePage();
		
		
	}
	
	@Test
	public void homePageTitleTest()
	{
		String homePageTitle=homepage.getTitle();
		String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test
	public void SearchTest()
	{
		signUp=homepage.searchFunction("Book");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
	
}
