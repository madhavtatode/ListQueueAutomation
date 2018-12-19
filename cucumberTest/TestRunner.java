package com.amadeus.selenium.ardNew.test.BDD.cucumberTest;

import org.junit.runner.RunWith;

import com.amadeus.selenium.ardNew.test.SeleniumARDTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
 features = "Feature",
 glue= {"com.amadeus.selenium.ardNew.test.BDD.stepDefinition","com.amadeus.selenium.ardNew.test.BDD.utilities"},
 dryRun = false,
 monochrome = true,
 plugin={"pretty"},
 tags= {"@MyTest"}
 )
public class TestRunner{

}
