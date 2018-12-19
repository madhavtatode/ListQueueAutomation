package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;
public class PNRDetailsPage {
	
	public PNRDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="#epnrRetrieves1_deletePNRFromAllQueues")
	public WebElement lnkDeletePNRFromAllQueues;
	
	@FindBy(how=How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Place on Queue')]")
	public WebElement btnPlaceOnQueue;
	
	@FindBy(how=How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Delay PNR')]")
	public WebElement btnDelayPNR;
	
	@FindBy(how = How.CSS,using="[id*=_remarksLink]")
	public WebElement lnkAddModifyDeleteRemarks;	

	@FindBy(how = How.CSS,using="dummy path")
	public WebElement lnkPNRQueueList ;
	
	@FindBy(how = How.XPATH,using="//span[contains(text(),'Home')]")
	public WebElement lnkHomeTab;
	
	@FindBy(how = How.CSS,using="body.printDisabled:nth-child(2) div.uic-ALF div.apftaskmgr div.tasks:nth-child(3) ul.uicTaskbar li.selectedFile.selected div.b div.c > span.uicTaskbarText")
	public WebElement tabPNR;
	
	@FindBy(how = How.CSS,using="body.printDisabled:nth-child(2) div.uic-ALC2 div.uicCardLayout div.uicCardLayoutPanel div.retrievePNR:nth-child(3) div.pnrLayoutWrapper.centerPanelWrapper:nth-child(4) div.pnrnavbar div.PNRNavBar:nth-child(3) div:nth-child(1) div.pnrButtonsContainer:nth-child(10) span.closeBtn:nth-child(4) > a")
	public WebElement btnColsePNR;
		
	public void clickOnAddModifyDeleteRemarks() throws InterruptedException {
		lnkAddModifyDeleteRemarks.click();
		waitMethod(3);
	}

	public void closePNR() throws InterruptedException {
		btnColsePNR.click();
		waitMethod(9);
	}

	public String getPNRNumber() {		
		return tabPNR.getText().substring(5, 11);
	}
	
}
