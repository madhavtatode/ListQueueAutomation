package com.amadeus.selenium.ardNew.test.BDD.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static com.amadeus.selenium.ardNew.test.BDD.stepDefinition.Test_Steps.*;
public class WaitElementDisplayCondition implements ExpectedCondition<Boolean> {

	protected By eltLocator;
	protected boolean positiveCondition;

	public WaitElementDisplayCondition(By eltLocator, boolean positiveCondition) {
	    super();
	    this.eltLocator = eltLocator;
	    this.positiveCondition = positiveCondition;
	  }

	@Override
	public Boolean apply(WebDriver arg0) {
	      boolean validCondition = false;
	      try {
	    	  
	        WebElement elt = driver.findElement(eltLocator); 
	        // elt exists
	        if (positiveCondition){
	          validCondition = elt.isDisplayed();
	        } else {
	          validCondition = !elt.isDisplayed();
	        }
	      } catch (NoSuchElementException e) {
	        // element does not exist yet
	        validCondition = !positiveCondition;
	      } catch (StaleElementReferenceException e) {
	        // element no more into the cache, so not displayed
	        validCondition = !positiveCondition;
	      }
	      return Boolean.valueOf(validCondition);
	}

}
