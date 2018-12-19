package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;


public class CommanPage {
	
	public CommanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS,using="[id*=_PNRNavBar_eotBtn_id]")
	public WebElement btnEOT; 
	
	@FindBy(how = How.CSS,using="[id*=_eotPanel_RECEIVED_FROM_id_input]")
	public WebElement txtbxReceivedFrom;
	
	@FindBy(how = How.CSS,using="[id*=_eotPanel_okBtn_id]")
	public WebElement btnEOTOk;
	
	public void enterReceivedFrom(String str) {
		txtbxReceivedFrom.sendKeys(str);
	}
	
	public void clickOnEOT() {
		btnEOT.click();
	}
	
	public void clickOnEOTOk() throws InterruptedException {
		btnEOTOk.click();
		waitMethod(15);
	}
}
