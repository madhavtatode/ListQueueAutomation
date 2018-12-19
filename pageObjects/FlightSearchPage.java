package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage {

	public FlightSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]/input[1]")
	@FindBy(how = How.CSS,using="input[id*='_airSearch_boundsTable_id_0_from']")
	public  WebElement txtbxFrom;
	
	//@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/input[1]")
	@FindBy(how = How.CSS,using="input[id*='_airSearch_boundsTable_id_0_to']")
	public  WebElement txtbxTo;
	
	//@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/span[1]/select[1]")
	@FindBy(how=How.CSS,using="[id*='searchType_searchType_id_input']")
	public  WebElement drpdwnSearchType;
	
	@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/span[1]/button[1]")
	public  WebElement lnkOpenCalendar;
	
	@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[31]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[4]/a[1]")
	public  WebElement lnkDate;
	
	
	//@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[3]/div[3]/button[1]/span[2]/strong[1]")
	@FindBy(how = How.CSS,using="[id*='_airSearch_search_id'] .uicButtonBd")
	public  WebElement btnSearch;
	
	@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/span[1]/button[1]/span[1]/span[2]/span[1]")
	public  WebElement btnSelectFare;
	
	
	//@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/span[2]/span[1]/button[1]")
	@FindBy(how = How.CSS,using="[id*=avResult_buttonBook_]")
	public WebElement btnBook;
	
	@FindBy(how = How.CSS,using="input[id*='_airSearch_boundsTable_id_0_date']")
	public WebElement txtbxDate;
	
	@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/div[1]/div[2]/div[1]/div[1]/span[2]")
	public WebElement lnkLowFareFlight;
								 ///html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]
	//@FindBy(how = How.XPATH,using="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	@FindBy(how = How.CSS,using="[id*='_updateLink']")
	public WebElement lnkAddUpdate;
	
	@FindBy(how = How.XPATH,using="//span/div[contains(@id,'pnrRetrieve')]")
	public WebElement btnNewPnrTab;
	
	@FindBy(how = How.XPATH,using="/html[1]/body[1]/iframe[2]")
	public WebElement frameAddUpdate;
	
	public void enterFromCity(String from) {
		txtbxFrom.click();
		txtbxFrom.sendKeys(from);
		txtbxFrom.sendKeys(Keys.TAB);
	}
	
	public void enterToCity(String to) {
		txtbxTo.click();
		txtbxTo.sendKeys(to);
		txtbxTo.sendKeys(Keys.TAB);
	}

	public void selectDate() {
		lnkOpenCalendar.click();
		lnkOpenCalendar.sendKeys(Keys.ARROW_DOWN);
		lnkOpenCalendar.sendKeys(Keys.TAB);
		//lnkDate.click();
	}

	public void clickOnSearch() {
		btnSearch.click();		
	}
	
	public void selectFlight() {
		lnkLowFareFlight.click();
	}
	
	public void clickOnSelectFare() {		
		btnSelectFare.click();
	}
	
	public void clickOnBook() {
		btnBook.click();
	}
	
	public void clickOnAddUpdate() {
		lnkAddUpdate.click();
	}
	
	public void clickOnNewPNRTab() {
		btnNewPnrTab.click();
	}

	public void searchFlight() throws InterruptedException {
		enterFromCity("SIN");
		enterToCity("BKK");
		selectDateNew();
		clickOnSearch();
		waitMethod(8);
	}

	private void selectDateNew() {
		txtbxDate.click();
		txtbxDate.clear();
		txtbxDate.sendKeys("30DEC18");
		txtbxDate.sendKeys(Keys.TAB);
	}

	public void bookFlights() throws InterruptedException {
		//selectFlight();
		//waitMethod(2);
		//clickOnSelectFare();
	    waitMethod(2);
		clickOnBook();
		waitMethod(8);
	}

	public void selectSearchType(String string) {
		Select select = new Select(drpdwnSearchType);
		select.selectByValue(string);
		
	}

	public void searchAndBookFlights() throws InterruptedException {
		//Select Search Type as availability
		selectSearchType("AV");
		waitMethod(3);
		
		//Search for Itinerary
		searchFlight();
		
		//Book a flight
		bookFlights();		
	}
}
