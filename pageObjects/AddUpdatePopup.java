package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;

public class AddUpdatePopup {
	
		public AddUpdatePopup(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
										 
		//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[10]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[2]/span[1]/input[1]")
		@FindBy(how = How.CSS,using="[id*='paxInfoTpl_lastName0'] input")
		public WebElement txtbxLastName;
		
		
		
		//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[10]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/input[1]")
		@FindBy(how = How.CSS,using="[id*='paxInfoTpl_firstName0'] input")
		public WebElement txtbxFirstName;
		
		
		//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[10]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/span[3]/div[1]/span[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/input[1]")
		@FindBy(how = How.CSS,using="[id*='_mainContactTableTpl_contactFreeTextInput'] input")
		public WebElement txtbxMobile;
		
		//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[10]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/span[2]/span[1]/button[1]")
		@FindBy(how = How.CSS,using="[id*='paxPopupColseButton'] button")
		public WebElement btnClose;
		
		@FindBy(how =How.CSS,using="[id*=paxPopupApplyButton] button")
		public WebElement btnApply;
		
		public void enterFirstName(String firstName){
			txtbxFirstName.sendKeys(firstName);
		}
		
		public void enterLastName(String lastName) {
			txtbxLastName.sendKeys(lastName);
		}
		
		public void enterMobile(String mobile) {
			txtbxMobile.sendKeys(mobile);
		}
		
		public void addPaxDetails() throws InterruptedException {
			enterLastName("TATODE");
			enterFirstName("MADHAV");
			enterMobile("1234567890");
			clickOnApply();
			waitMethod(3);
			clickOnClose();
			waitMethod(8);
		}
		
		public void clickOnClose() {
			btnClose.click();
		}
		
		public void clickOnApply() {
			btnApply.click();
		}
}
