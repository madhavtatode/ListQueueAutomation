package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;
import geb.waiting.WaitTimeoutException;

public class RemarksPopup {
	
	@FindBy(how=How.ID,using="eremarkss1_remarksForm_remarksType_id_input")
	public Select selectRemarkType;
	
	@FindBy(how=How.CSS,using="[id*='_remarksForm_remarksFreeText_id_input']")
	public WebElement txtbxDetails;
	
	@FindBy(how=How.CSS,using="#eremarkss1_remarksForm_addRemarks_id>.uicButtonBd")
	public WebElement btnAddRemark;
	
	@FindBy(how=How.CSS,using="#eremarkss1_remarksButtonbar_okButton_id>.uicButtonBd")
	public WebElement btnCloseRemarkPopup;
	
	public RemarksPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBtnAddRemark() throws InterruptedException {
		btnAddRemark.click();
		waitMethod(3);
	}
	
	public void enterRemarkDetails() {
		txtbxDetails.sendKeys("Hello Remarks");
	}
	
	public void clickOnBtnCloseRemarksPopup() throws InterruptedException {
		btnCloseRemarkPopup.click();
		waitMethod(4);
	}
	
	public void addRemark() throws InterruptedException{
		enterRemarkDetails();
		clickOnBtnAddRemark();
		clickOnBtnCloseRemarksPopup();		
	}
}
