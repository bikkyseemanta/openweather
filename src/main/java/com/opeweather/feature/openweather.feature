Feature: Openweather automation

@Verify_labels_links
Scenario Outline: Verify labels and links in openweather site
Given opens the browser 
Then verify that all labels and links in openweather site


Examples:
    | UserId | Password |   
    |   1    |  43      | 

    
@Verify_invalid_city
Scenario Outline: Verify invalid city name in openweather site
Given opens the browser 
Then Enter an invalid city name "<city>"
And Search for weather
Then verify that website suggest the city is not found


Examples:
    | city           | 
    |   kundalhali   | 
    
    
@Verify_valid_city
Scenario Outline: Verify invalid city name in openweather site
Given opens the browser 
Then Enter a valid city name "<city>"
And Search for weather
Then verify that website website successfully returns weather details for the city   

Examples:
    | city           | 
    |   Bangalore   | 
        
@Additional_TestCase
Scenario Outline: Convert the weather temperature from Celcius to Fahrenheit
Given opens the browser 
Then Enter a valid city name "<cityname>"
And Search for weather
Then verify that website website successfully returns weather details for the city
Then convert the searched temperature to Fahrenheit
And validate the temperature  

Examples:
    | cityname          | 
    |   Bangalore   |

        