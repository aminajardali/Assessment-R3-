![image](https://github.com/aminajardali/Assessment-R3-/assets/167747357/d973eaa2-4fd5-4491-b1c6-9d3bb978ed5e)
## Assessment Project
Given the API: h􀆩ps://open.er-api.com/v6/latest/USD
Returns the USD rates against mul􀆟ple currency.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src/
|-- main/
|   |-- java/
|       |-- api/
|           |-- ApiClient.java  
|       |-- utils/
|           |-- JsonSchemaValidator.java
|-- test/
    |-- java/
        |-- API/
            |-- ApiCallStepDefs.java
            |-- CurrencyConvStepdefs.java
            |-- DataCompleteStepdefs.java
            |-- ResponseTimeStepdefs.java 
        |-- TestRunner.java

    |-- resources/
        |-- features/Api
            |-- APICall.feature
            |-- CurrencyConverstion.feature
            |-- DataCompleteness.feature
            |-- RespTime.feature
```


## The sample scenario
-Feature: Validate API response and structure

  .Scenario: API call is successful and returns a valid price
    Given the API is available
    When I request the current price
    Then the API call should be successful
    And the response should include a valid price

  .Scenario: API response status code and status check
    Given the API is available
    When I request the current price
    Then the API response should return a status code of 200
    And the API response status should be "success"

  .Scenario: Validate API response JSON schema
    Given the API is available
    When I request the current price
    Then the API response should match the defined JSON schema


-Feature: Currency conversion rate accuracy

  .Scenario: Fetch USD price against AED and check range
    Given the API is available
    When I fetch the conversion rate for USD to AED
    Then the conversion rate should be between 3.6 and 3.7
    

-Feature: Validate number of currency pairs returned

  .Scenario: Verify the number of currency pairs
    Given the API is available
    When I request the list of all currency pairs
    Then the API should return exactly 162 currency pairs
    

-Feature: API response time validation

  .Scenario: Verify API response time
    Given the API is available
    When I request any data
    Then the response time should not be more than 3 seconds from the request time
    
## Installation and Setup

fork the starter of serinity cucumber from the repository https://github.com/serenity-bdd/serenity-cucumber-starter , it have the main needed dependancies and plugins.
addition to the ones in the pom.xml i downloaded the com.squareup.okhttp3.3.6.0 and the com.google.code.gson.2.8.9
and include this code :

        <dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>3.6.0</version>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.9</version>
        </dependency>
        
  ## Configuration and Running

  Configuration using TestRunner :
  
    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;
    
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "API",
            plugin = {"pretty", "html:target/cucumber-reports"}
    )
    public class TestRunner {
    }

  You can run this and choose the features you want to check their status 

  or by manually running them from the feature files, but you should "modify run Configuration" , by changing the Main class to net.cucumber.core.cli.main ,
  and the Glue to API or net.serenitybdd.cucumber.actors API

## API Documentation Reference

https://www.exchangerate-api.com/docs/free

## Testing Results

![image](https://github.com/aminajardali/Assessment-R3-/assets/167747357/8098a9c0-678c-4bb5-827d-c0cd4f61524c)
![image](https://github.com/aminajardali/Assessment-R3-/assets/167747357/49f95abd-3624-48ee-bd7f-2019c23e7334)


## Contact Information
For further inquiries or support, please contact the project maintainers at amina.jardali@digitalchain.tech 




  

  


        


