package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.utill.TestUtil;

public class TestBaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBaseClass()
	
	{
		
		
		try
		{
			prop=new Properties();
			FileInputStream inputConfigFile=new FileInputStream("F:\\Python-Programs\\Amazon\\src\\main\\java\\com\\amazon\\configuration\\config.properties");
			prop.load(inputConfigFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		//String webDriverPath=prop.getProperty("chomrDriverPath");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Salenium- Leaaring-Software\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
}
