package com.openweather.runner;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src\\main\\java\\com\\opeweather\\feature\\openweather.feature",
		glue = {"com.openweather" }, 
		monochrome = true, 
		dryRun = false,
		strict = true,
		 format =
		 {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		tags = { "@Verify_labels_links,@Verify_invalid_city,@Verify_valid_city,@Additional_TestCase" })
public class Runner_openweather {

}
