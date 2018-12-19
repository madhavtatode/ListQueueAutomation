package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PlacePNROnQueuePopup {

	public PlacePNROnQueuePopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS,using="#epnrRetrieves1_placePNR_TARGET_QUEUE_NUMBER_id_input")
	public WebElement txtbxQueueNumber;
	
	@FindBy(how = How.CSS,using="#epnrRetrieves1_placePNR_TARGET_CATEGORY_id_input")
	public WebElement txtbxcategoryNumber;
	
	@FindBy(how = How.XPATH,using="//button[@id='epnrRetrieves1_placePNR_placeButton_id']//span[@class='uicButtonBd']//strong[contains(text(),'OK')]")
	public WebElement btnOk;
}
