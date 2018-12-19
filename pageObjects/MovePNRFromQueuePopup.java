package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MovePNRFromQueuePopup {
		
	public MovePNRFromQueuePopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="//a[@id='equeue_movePNRLink']")
	public WebElement lnkMovePNRFromQueue;
								 
	@FindBy(how = How.CSS,using="body.printDisabled:nth-child(2) div.uic-ALC2 div.uicCardLayout div.uicCardLayoutPanel div.ardAccordion:nth-child(7) div.uicSplitter.homeSplitter.uicSplitterBorder:nth-child(4) div.uicSHSlot:nth-child(3) div.uicSplitterPanel div.resultSplitterWrapper div.uicSplitter.resultSplitter.uicSplitterNoBorder div.uicSVSlot:nth-child(1) div.uicSplitterPanel div.Queue:nth-child(5) div.queue div.PNRList:nth-child(3) div.PNRListBox div.PNRListContainer > pre")
	public WebElement listPNR;
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_selectPNR_id_some")
	public WebElement radioBtnSelectedPNRs ;
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_PNR_LINENUMBERS_id_input")
	public WebElement txtbxSelectedPNRs;
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_QUEUE_NUMBER_id_input")
	public WebElement txtbxQueueNumber;
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_CATEGORY_id_input")
	public WebElement txtbxCategoryNumber;
	
	@FindBy(how = How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Move PNRs')]")
	public WebElement btnMovePNRs;
}
