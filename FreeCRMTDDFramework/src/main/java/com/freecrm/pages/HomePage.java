package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.baseclass.TestBase;
import com.freecrm.util.TestUtil;

public class HomePage extends TestBase
{
	
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement logoTxt;
	
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calendar;
	
	@FindBy(xpath="//a[contains(text(),'New Event')]")
	WebElement newEvent;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	
	@FindBy(xpath="//a[contains(text(),'Week View')]")
	WebElement weekView;
	
	@FindBy(xpath="//a[contains(text(),'Month View')]")
	WebElement monthView;
	
	
	@FindBy(xpath="//tr[3]//td[2]//img[2]")
	WebElement cancleBtn1;
	
	@FindBy(xpath="//tr[4]//td[2]//img[2]")
	WebElement cancleBtn2;
	
	@FindBy(xpath="//img[@id='f_trigger_c_start']")
	WebElement fromDate;
	
	@FindBy(xpath="//td[@class='title']")
	WebElement monthYear;
	
	
	@FindBy(xpath="//img[@id='f_trigger_c_end']")
	WebElement todate;
	
	@FindBy(xpath="//select[@name='category']")
	WebElement category;
	
	@FindBy(xpath="//select[@name='reminder_minutes']")
	WebElement remindertime;
	
	@FindBy(xpath="//select[@name='reminder_type']")
	WebElement reminderType;
	
	@FindBy(xpath="//tr[13]//td[2]//input[4]")
	WebElement companyLookup;
	
	@FindBy(xpath="//tr[13]//td[2]//input[4]")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='email_alert']")
	WebElement emailCheckBox;
	
	@FindBy(xpath="//input[@id='fieldId_start']")
	WebElement dateinput1;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String verifylogoTxt()
	{
		TestUtil.switchFrame("mainpanel");
       String logo = null;
		if(logoTxt.isDisplayed())
		{
			logo=logoTxt.getText();
		}
		return logo;
	}
	
	
	public void verifyNewEventFunctionality(String title1,String	fromdate1,String	todate1,String	category1,String	contact1,String	company1,String	remaindertime1,String	remaindeVia1)
	{
		
	TestUtil.switchFrame("mainpanel");
	TestUtil.mouseMove(calendar);
	String[] date1=TestUtil.splitString(fromdate1," ");
	String[] date2=TestUtil.splitString(todate1, " ");
	
	newEvent.click();
	title.sendKeys(title1);
	cancleBtn1.click();
	fromDate.click();
	String fromDt=monthYear.getText(); //June, 2020
	String[] fromDtSplit=fromDt.split(",");
	//if(fromDtSplit[1].substring(1).equals(date1[2]))
	
		if(fromDtSplit[0].equals(date1[1]))
		{
			
			driver.findElement(By.xpath("//td[contains(text(),"+date1[0]+")]")).click();;
		}
	//}
	
	

			
	}

	
	
	
	
	
}
