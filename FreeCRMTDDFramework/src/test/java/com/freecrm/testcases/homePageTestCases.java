package com.freecrm.testcases;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.baseclass.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class homePageTestCases extends TestBase

{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(homePageTestCases.class);
	private static final Log log1 = LogFactory.getLog(homePageTestCases.class);

	public homePageTestCases()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login();
		
	}
	
	
	@Test(priority=1)
	public void testHomePageLogo()
	{
	//	log.info("****************************** starting test case *****************************************");
		//log.info("****************************** freeCrmTitleTest *****************************************");
		Assert.assertEquals(homePage.verifylogoTxt(), "CRMPRO");
		//.info("****************************** ending test case *****************************************");
		//log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtil.getTestData("CRM_Cal_NewEvent");
		return data;
	}
	
	@Test(priority=2 , dataProvider="getCRMTestData")
	public void TestNewEventFunctionality(String title,String	fromdate,String	todate,String	category,String	contact,String	company,String	remaindertime,String	remaindeVia
)
	{
		//log.info("****************************** starting test case *****************************************");
		homePage.verifyNewEventFunctionality(title,	fromdate	,todate,	category,	contact	,company,	remaindertime	,remaindeVia);
		//log.info("****************************** ending test case *****************************************");
	//	log.info("****************************** freeCrmTitleTest *****************************************");
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