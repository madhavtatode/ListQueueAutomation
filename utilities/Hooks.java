package com.amadeus.selenium.ardNew.test.BDD.utilities;

import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.*;
import static com.amadeus.selenium.ardNew.test.BDD.stepDefinition.Test_Steps.*;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.LoginPage;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.*;
public class Hooks {

	@Before("@6X")
	public void beforeScenario6X() throws InterruptedException {
		System.out.println("Executing before");
		// HomePage homeTopPanel=LoginHelper.login();
		driver = initializeDriver(driver);

		// launch the url
		driver.get(URL6X);
		waitMethod(10);

		// Login
		loginPage = new LoginPage(driver);
		loginPage.login();
		System.out.println("Login overlay started : "+ java.time.LocalTime.now());
		waitForOverlayLoading(250);
		System.out.println("Login overlay ended : "+ java.time.LocalTime.now());
	}

	
	@Before("@SQ")
	public void beforeScenarioSQ() throws InterruptedException {
		System.out.println("Executing before");
		// setTestData("MNRE_JL_014_CR9633122_Verify_Low_Fare_Search_Layout_Simple_Search_mode");
		// HomePage homeTopPanel=LoginHelper.login();
		System.out.println("Executing scenario 1 given 1");

		// HomePage homeTopPanel=LoginHelper.login();
		driver = initializeDriver(driver);

		// launch the url
		driver.get(URLSQ);
		waitMethod(10);
		//6
		// Login
		loginPage = new LoginPage(driver);
		loginPage.login();
//		waitForOverlayLoading(250);
		waitMethod(40);
		//25
		System.out.println("After wait over");
	}	
	@After
	public void afterScenario() {
		System.out.println("Executing after");
	}
}
