package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.baseclass.TestBase;

public class TestUtil extends TestBase
{
	public static Workbook book;
	public static Sheet sheet;
	

	/*public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}*/
	
	public static  void click(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public  void displayed(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeSelected(element));
				
		
	}
	
	public static void switchFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public static void mouseMove(WebElement element)
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();;
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		
		try
		{
			file=new FileInputStream("F:\\Python-Programs\\FreeCRMTDDFramework\\src\\main\\java\\com\\freecrm\\testdata\\TestData.xlsx");
		}
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	

	public static String[] splitString(String srt, String reg) {
		String[] result= srt.split(reg);
		return result;
	}
	
	public static void selectdateByJS(WebElement element, String date, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script= "arguments[0].setAttribute('value','"+date+"');";
		js.executeScript(script, element);
	
	}
	
	

	
	
		
	

	
}
