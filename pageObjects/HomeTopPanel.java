package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.*;

public class HomeTopPanel {

	public static By LOC_LK_ADD_PAX = By.cssSelector("[id*='_updateLink']");

	public HomeTopPanel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]")
	public WebElement lnkCreateNewPNR;

	@FindBy(how = How.ID, using = "esearch_dataquicksearchflat_complex_id_input")
	public WebElement txtbxPNRSearch;

	@FindBy(how = How.CSS, using = "#esearch_dataquicksearchflat_quickSearchButton_id")
	public WebElement btnRetrieve;

	public void clickOnCreateNewPNR() throws InterruptedException {
		lnkCreateNewPNR.click();
		pageSync(LOC_LK_ADD_PAX, 100);
		System.out.println("click pnr overlay started : " + java.time.LocalTime.now());
		waitForOverlayLoading(45);
		System.out.println("click pnr overlay ended : " + java.time.LocalTime.now());
	}

	public void retrievePNR(String pnr) throws InterruptedException {
		txtbxPNRSearch.sendKeys(pnr);
		btnRetrieve.click();
		waitMethod(30);
	}

}
