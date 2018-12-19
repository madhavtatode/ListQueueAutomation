package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static com.amadeus.selenium.ardNew.test.BDD.stepDefinition.Test_Steps.*;
public class PNRQueueListPopup {

	
	public PNRQueueListPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS,using = "dummy")
	public WebElement lnkNext;
	
	@FindBy(how = How.CSS,using = "dummy")
	public WebElement lnkPrevious;
 	
	@FindBy(how = How.CSS,using = "dummy")
	public WebElement divPopup;
	
	@FindBy(how = How.CSS,using="dummy")
	public WebElement btnClose;
	
	public String getTextResponse() {
		return null;
	}

	public boolean isPopupDisplayed() {
		return divPopup.isDisplayed();
	}
	
	

	
	
}
