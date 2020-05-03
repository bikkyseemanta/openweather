package com.openweather.commonmethods;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonMethod 
{

	public static WebDriver driver;
	 public static WebElement element;
	
	
	public static void browser_and_url_open() throws Throwable 
	{
		System.setProperty(readProperty("browserkey"),
				readProperty("browservalue"));
		//Reporter.addStepLog("Browser Opening");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(readProperty("url"));
		//Reporter.addStepLog("Opening the url [ "+readProperty("url")+ " ]");
	}
	 
	
	public static String readProperty(String key) throws Exception
	{
		FileReader reader=new FileReader("C:\\Users\\Admin\\eclipse-workspace\\com.openweather\\src\\main\\resources\\configuration.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    
	    String value = p.getProperty(key);
	    return value;
	}
}
