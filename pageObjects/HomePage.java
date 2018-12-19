package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]")
	public WebElement lnkCreateNewPNR ;
	
	public void clickOnCreateNewPNR() {
		lnkCreateNewPNR.click();
	}
}
