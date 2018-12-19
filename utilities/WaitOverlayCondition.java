package com.amadeus.selenium.ardNew.test.BDD.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitOverlayCondition  implements ExpectedCondition<Boolean> {
	protected final static By LOC_DIV_OVERLAY_LOADING = By.cssSelector("div.uicLoaderOverlay.uicLo-loading");
	
	 public Boolean apply(WebDriver webDriver)
	  {
	      boolean validCondition = true;

	      List<WebElement> eltList = webDriver.findElements(LOC_DIV_OVERLAY_LOADING);
	      for(WebElement elt: eltList) {
	        // elt exists
	        try {
	          if (elt != null && elt.isDisplayed()) {
	            validCondition = false;
	            break;
	          }
	        } catch (StaleElementReferenceException e) {
	          // element no more into the cache, so not displayed
	          continue;
	        }catch(WebDriverException e){
	          break;
	        }
	      }
	      return Boolean.valueOf(validCondition);
	  }
}
