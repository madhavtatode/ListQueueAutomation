package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PNRListPage {
	
	public PNRListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS,using = "#equeue_queueMenu_queueNumber_id_input")
	public WebElement txtbxQueueNumber;
	
	@FindBy(how = How.CSS,using = "#equeue_queueMenu_categoryNumber_id_input")
	public WebElement txtbxCategorynumber;
	
	@FindBy(how = How.CSS,using = "body.printDisabled:nth-child(2) div.uic-ALC2 div.uicCardLayout div.uicCardLayoutPanel div.ardAccordion:nth-child(7) div.uicSplitter.homeSplitter.uicSplitterBorder:nth-child(4) div.uicSHSlot:nth-child(1) div.uicSplitterPanel dl.uicAccordion.ardMenuAccordion dd.uicAccordion.uicOverflow.Queue.open:nth-child(6) div.queue div.queueMenu:nth-child(3) button.uicButton.uicButtonNormal.PNRList.queueMenuButton:nth-child(8) span.uicButtonBd > strong:nth-child(1)")
	public WebElement btnDisplayPNRList;
	
	@FindBy(how = How.CSS,using = "body.printDisabled:nth-child(2) div.uic-ALC2 div.uicCardLayout div.uicCardLayoutPanel div.ardAccordion:nth-child(7) div.uicSplitter.homeSplitter.uicSplitterBorder:nth-child(4) div.uicSHSlot:nth-child(3) div.uicSplitterPanel div.resultSplitterWrapper div.uicSplitter.resultSplitter.uicSplitterNoBorder div.uicSVSlot:nth-child(1) div.uicSplitterPanel div.Queue:nth-child(6) div.queue div.PNRList:nth-child(3) div.PNRListBox div.PNRNavigator > a.nextPage")
	public WebElement lnkNext;
	
	@FindBy(how = How.CSS,using = "body.printDisabled:nth-child(2) div.uic-ALC2 div.uicCardLayout div.uicCardLayoutPanel div.ardAccordion:nth-child(7) div.uicSplitter.homeSplitter.uicSplitterBorder:nth-child(4) div.uicSHSlot:nth-child(3) div.uicSplitterPanel div.resultSplitterWrapper div.uicSplitter.resultSplitter.uicSplitterNoBorder div.uicSVSlot:nth-child(1) div.uicSplitterPanel div.Queue:nth-child(6) div.queue div.PNRList:nth-child(3) div.PNRListBox div.PNRNavigator > a.previousPage")
	public WebElement lnkPrevious;
	
}
