package com.freecrm.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.freecrm.util.WebEventListener;

public class TestBase 
{

	public static Properties prop;
	public static FileInputStream ip;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	
	public TestBase()
	{
		prop=new Properties();
		try {
			 ip=new FileInputStream("F:\\Python-Programs\\FreeCRMTDDFramework\\src\\main\\java\\com\\freecrm\\config\\config.properties");
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Salenium- Leaaring-Software\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",  "F:\\Salenium- Leaaring-Software\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
//		e_driver=new EventFiringWebDriver(driver);
//		eventListener=new WebEventListener();
//		e_driver.register(eventListener);
//		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
}
