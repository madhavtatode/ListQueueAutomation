package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeletePNRFromAllQueuesQueueAccordionPopup {

	
	public DeletePNRFromAllQueuesQueueAccordionPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID,using="tpl20_deleteButton")
	public WebElement btnDelete;
	
	@FindBy(how = How.ID,using="tpl20_cancelButton")
	public WebElement btnCancel;
}
