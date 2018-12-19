package com.amadeus.selenium.ardNew.test.BDD.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitElementEnableCondition implements ExpectedCondition<Boolean> {
	  protected By eltLocator;
	  protected boolean positiveCondition;

	  /**
	   * Constructor
	   * @param eltLocator  the element locator
	   * @param positiveCondition flag for positive or negative condition (Visible or invisible)
	   */
	  public WaitElementEnableCondition(By eltLocator, boolean positiveCondition) {
	    super();
	    this.eltLocator = eltLocator;
	    this.positiveCondition = positiveCondition;
	  }

	  public Boolean apply(WebDriver webDriver)
	  {
	      boolean validCondition = false;
	      try {
	        WebElement elt = webDriver.findElement(eltLocator);
	        // elt exists
	        if (positiveCondition){
	          validCondition = elt.isEnabled();
	        } else {
	          validCondition = !elt.isEnabled();
	        }
	      } catch (NoSuchElementException e) {
	        validCondition = !positiveCondition;
	      } catch (StaleElementReferenceException e) {
	        // element no more into the cache, so not enable
	        validCondition = !positiveCondition;
	      }
	      return Boolean.valueOf(validCondition);
	  }
}
