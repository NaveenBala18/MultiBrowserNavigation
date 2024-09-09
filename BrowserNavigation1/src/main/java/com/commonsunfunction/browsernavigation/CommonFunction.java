package com.commonsunfunction.browsernavigation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunction 
{
	public static Properties property=null;
	public static WebDriver driver = null;
	
	@BeforeSuite
	public Properties invokePropertyFile() throws IOException	
	{
		FileInputStream file = new FileInputStream("config.properties");
		property = new Properties();
		property.load(file);
		return property;
	}
	
	
	@Test
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))	
		{
			driver = new EdgeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))	
		{
			driver = new FirefoxDriver();
		}
		 
		driver.manage().window().maximize();
		driver.get(url);	
		}
	
//	@AfterSuite
//	public void broserTermination()
//	{
//		driver.quit();
//	}
}
