package com.openweather;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.openweather.commonmethods.CommonMethod;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Method extends CommonMethod
{
	//WebDriver driver;
	@Given("^opens the browser$")
	public void opens_the_browser() throws Throwable 
	{
		browser_and_url_open();
	}

	@Then("^verify that all labels and links in openweather site$")
	public void verify_that_all_labels_and_links_in_openweather_site() throws Throwable 
	{
		//Verify the count of labels in a page.
		List<WebElement> label=driver.findElements(By.xpath("//label"));
		//System.out.println(label.size());
		Reporter.addStepLog("The no of labels present in the dashboard page is "+ label.size());

		//Print all label values 
		for(int i=0;i<label.size();i++)
		{
			//System.out.println(label.get(i).getText());
			Reporter.addStepLog("The no of labels present in the dashboard page is "+ label.get(i).getText());
		}

		//Verify the count of links in a page
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		System.out.println(links.size());

		//Print all links values 
		for(int i=0;i<links.size();i++)
		{
			//System.out.println(links.get(i).getText());
			Reporter.addStepLog("The no of labels present in the dashboard page is "+ links.get(i).getText());
		}


	}

	//Enter invalid city name
	@Then("^Enter an invalid city name \"([^\"]*)\"$")
	public void enter_an_invalid_city_name(String city) throws Throwable 
	{
		driver.findElement(By.xpath("//label[text()='Search']/..//input")).sendKeys(city);
	}

	//Click on search button
	@Then("^Search for weather$")
	public void search_for_weather() throws Throwable 
	{
		driver.findElement(By.xpath("(//button[@type='submit']/..//i)[2]")).click();
		Thread.sleep(2000);
		//allow cookies
		driver.findElement(By.xpath("//*[text()='Allow all']")).click();
		
	}
    //Verify the website suggest the city is not found
	@Then("^verify that website suggest the city is not found$")
	public void verify_that_website_suggest_the_city_is_not_found() throws Throwable 
	{   
		
		if(driver.findElement(By.xpath("//*[@class='alert alert-warning']")).isDisplayed())
		{
			//System.out.println("Search is not working for invalid city-->Test Pass");
			Reporter.addStepLog("Search is not working for invalid city-->Test Pass");
		   
		}
	      else
		{
			//System.out.println("Search is working for invalid city-->DEFECT");
			Reporter.addStepLog("Search is working for invalid city-->DEFECT");
		}
	}
	//Enter valid city name
	@Then("^Enter a valid city name \"([^\"]*)\"$")
	public void enter_a_valid_city_name(String cityname) throws Throwable 
	{
		driver.findElement(By.xpath("//label[text()='Search']/..//input")).sendKeys(cityname);
		//driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cityname);
		Thread.sleep(1000);
	}
    
	//Verify that website successfully return the temperature
	@Then("^verify that website website successfully returns weather details for the city$")
	public void verify_that_website_website_successfully_returns_weather_details_for_the_city() throws Throwable 
	{
	    if(driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]")).isDisplayed())
	    {   
	    	//System.out.println("Website successfully returns weather details for valid city-->Test Pass");
	    	Reporter.addStepLog("Website successfully returns weather details for valid city-->Test Pass");
	    	String weather=driver.findElement(By.xpath("//*[@class='badge badge-info']/..//span")).getText();
	    	//System.out.println("Today's weather for given city is -->"+weather );
	    	Reporter.addStepLog("Today's weather for given city is -->"+weather);
	    }
	    else
	    {
	    	//System.out.println("Website not searching weather details for valid city-->DEFECT");
	    	Reporter.addStepLog("Website not searching weather details for valid city-->DEFECT");
	    }
	}
   
	@Then("^convert the searched temperature to Fahrenheit$")
	public void convert_the_searched_temperature_to_Fahrenheit() throws Throwable
	{
	    driver.findElement(By.xpath("//span[text()='°F']")).click();
	    Thread.sleep(3000);
	    
	}

	@Then("^validate the temperature$")
	public void validate_the_temperature() throws Throwable 
	{
		String weather=driver.findElement(By.xpath("//*[@class='badge badge-info']/..//span")).getText();
		
		if(weather.contains("°F"))
		{
			//System.out.println("Upon click on Fahrenheit the temperature displaying in Fahrenheit-->Test Pass ");
			Reporter.addStepLog("Upon click on Fahrenheit the temperature displaying in Fahrenheit-->Test Pass ");
		}
		else
		{
			//System.out.println("Upon click on Fahrenheit the temperature still displaying in Celcius-->DEFECT");
			Reporter.addStepLog("Upon click on Fahrenheit the temperature still displaying in Celcius-->DEFECT");
		}
	}

}
