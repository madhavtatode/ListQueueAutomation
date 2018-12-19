package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;
public class DelayPNRPopup {

	
	
	public DelayPNRPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using = "//span[@class='uicButtonBd']//strong[contains(text(),'Delay and Exit Queue')]")
	public WebElement btnDelayAndExitQueue;	
	
	@FindBy(how=How.CSS,using="#epnrRetrieves1_delayPNR_REASON_id_input")
	public  WebElement drpdwnReason;	
	
	public void delayPNR() throws InterruptedException {
		Select select = new Select(drpdwnReason);
		select.selectByValue("no Answer");
		btnDelayAndExitQueue.click();
		waitMethod(9);
	}
}
