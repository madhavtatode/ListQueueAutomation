package com.amadeus.selenium.ardNew.test.BDD.stepDefinition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.amadeus.selenium.ardNew.helper.LoginHelper;
import com.amadeus.selenium.ardNew.test.SeleniumARDTest;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.*;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.PNRDetailsPage;
import com.amadeus.selenium.ardNew.test.BDD.utilities.WaitMultipleOverlayCondition;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.AddUpdatePopup;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.CommanPage;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.FlightSearchPage;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.HomePage;
import com.amadeus.selenium.ardNew.test.BDD.pageObjects.LoginPage;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.*;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	public static String URLSQ = "https://ncebpm1146aph01.etv.nce.amadeus.net/app_ard/apf/init/login?SITE=ASQBASQB&LANGUAGE=GB&recordActions=true&MARKETS=ARDW_UAT_INTRA_APAC,ARDW_SQ_QA&event=LOGIN_LOGOUT#";
	public static String URL6X = "https://ncebpm1146aph01.etv.nce.amadeus.net/app_ard/apf/init/login?SITE=A6XBA6XB&LANGUAGE=GB&recordActions=true&MARKETS=ARDW_UAT_INTER,ARDW_6X_QA";
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomeTopPanel homeTopPanel;
	public static FlightSearchPage flightSearchPage;
	public static AddUpdatePopup addUpdatePopup;
	public static CommanPage commanPage;
	public static RemarksPopup remarksPopup;
	public static PNRDetailsPage pnrDetailsPage;
	public static HomeLeftPanel homeLeftPanel;
	public static PNRListPage pnrListPage;
	public static PNRQueueListPopup pnrQueueListPopup;
	public static PlacePNROnQueuePopup placePNROnQueuePopup;
	public static DeletePNRFromAllQueuesPopup deletePNRFromAllQueuesPopup;
	public static DeletePNRFromAllQueuesQueueAccordionPopup deletePNRFromAllQueuesQueueAccordionPopup;
	public static MovePNRFromQueuePopup movePNRFromQueuePopup;
	public static String rtqCrypticResponse;
	public static String pnr;
	public static DelayPNRPopup delayPNRPopup;
	
	public  Set<String> queueSet = new HashSet<>(); 
	
	@Given("mandatory elements are added or not added as well")
	public void mandatory_elements_are_added_or_not_added_as_well() throws InterruptedException {

		// Click on create new PNR
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.clickOnCreateNewPNR();
		//waitMethod(13);

		// Search and book flights
		flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.searchAndBookFlights();

		// CLick on add update link
		flightSearchPage.clickOnAddUpdate();
		waitMethod(4);

		// Add pax details
		addUpdatePopup = new AddUpdatePopup(driver);
		addUpdatePopup.addPaxDetails();

	}

	@Given("Record locator is not yet created")
	public void record_locator_is_not_yet_created() throws InterruptedException {
		// Nothing needs to be done here
		System.out.println("Executing scenario 1 given 2");
	}

	@When("PNR details page is displayed")
	public void pnr_details_page_is_displayed() throws InterruptedException {
		System.out.println("Executing comman when");
		flightSearchPage.btnNewPnrTab.click();
		waitMethod(10);
	}

	@Given("mandatory elements are added")
	public void mandatory_elements_are_added() throws InterruptedException {
		// Click on create new PNR
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.clickOnCreateNewPNR();
		waitMethod(13);

		// Search and book flights
		flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.searchAndBookFlights();

		// CLick on add update link
		flightSearchPage.clickOnAddUpdate();
		waitMethod(4);

		// Add pax details
		addUpdatePopup = new AddUpdatePopup(driver);
		addUpdatePopup.addPaxDetails();
	}

	@When("EOT is successful and Recloc is created")
	public void eot_is_successful_and_Recloc_is_created() throws InterruptedException {
		commanPage = new CommanPage(driver);
		commanPage.clickOnEOT();
		waitMethod(4);
		commanPage.enterReceivedFrom("123");
		commanPage.clickOnEOTOk();
		
	}

	@Then("PNR Queue List link will be disabled")
	public void pnr_Queue_List_link_will_be_disabled() {
		assertEquals(false, pnrDetailsPage.lnkPNRQueueList.isEnabled());
	}

	@Then("PNR Queue List link will be  enabled")
	public void pnr_Queue_List_link_will_be_enabled() {
		assertEquals(true, pnrDetailsPage.lnkPNRQueueList.isEnabled());
	}

	@Given("PNR is created and not present in any Queue")
	public void pnr_is_created_and_not_present_in_any_Queue() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		
		System.out.println(rtqCrypticResponse);
		
		homeTopPanel = new HomeTopPanel(driver);
		
		homeTopPanel.retrievePNR(pnr);
	}

	@When("User clicks on PNR Queue List link")
	public void user_clicks_on_PNR_Queue_List_link() {
		pnrDetailsPage = new PNRDetailsPage(driver);
		
		pnrDetailsPage.lnkPNRQueueList.click();

		pnrQueueListPopup = new PNRQueueListPopup(driver);
	}

	@Then("An error “PNR ______ CURRENTLY NOT ON ANY QUEUE” as returned by CS should be displayed in the {string} pop up")
	public void an_error_PNR________CURRENTLY_NOT_ON_ANY_QUEUE_as_returned_by_CS_should_be_displayed_in_the_pop_up(
			String string) {
		
		//String errorMsg = "Error Message";
		
		pnrQueueListPopup = new PNRQueueListPopup(driver);
		
		assertEquals(rtqCrypticResponse, pnrQueueListPopup.getTextResponse());
	}

	@Given("PNR is created and present in at least {int} Queue")
	public void pnr_is_created_and_present_in_at_least_Queue(Integer int1) throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);


		pnr = homeLeftPanel.createCrypticPNR(driver);
		
		homeLeftPanel.pushIntoSingleQueues(pnr);

		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@When("User modifies any details in the PNR")
	public void user_modifies_any_details_in_the_PNR() throws InterruptedException {
		// click on add/modify/delete remarks
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnrDetailsPage.clickOnAddModifyDeleteRemarks();

		// Add Remarks
		remarksPopup = new RemarksPopup(driver);
		remarksPopup.addRemark();
	}

	@When("Does not perform an EOT")
	public void does_not_perform_an_EOT() {
		// Nothing needs to be done here
		System.out.println("Nothing to be done here");
	}

	@Then("PNR Queue List pop up should be displayed with all the Queues in which the PNR is present as returned by CS")
	public void pnr_Queue_List_pop_up_should_be_displayed_with_all_the_Queues_in_which_the_PNR_is_present_as_returned_by_CS() {
		assertEquals(rtqCrypticResponse, pnrQueueListPopup.getTextResponse());
	}

	public static WebDriver initializeDriver(WebDriver driver) {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium_drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@Given("PNR list is displayed for a Queue")
	public void pnr_list_is_displayed_for_a_Queue() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);
		pnr = homeLeftPanel.createCrypticPNR(driver);
		homeLeftPanel.pushIntoSingleQueues(pnr);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);		
		homeLeftPanel.compressLeftAccordion("Tools");
		waitMethod(2);
		homeLeftPanel.expandLeftAccordion("Queue");
		
		homeLeftPanel.txtbxQueueNumberToStart.sendKeys("1");
		homeLeftPanel.txtbxCategoryNumberToStart.sendKeys("1");
		homeLeftPanel.btnDisplayPNRList.click();
		waitMethod(15);
	}

	@When("User moves a PNR to another queue  using Move PNR from Queue feature")
	public void user_moves_a_PNR_to_another_queue_using_Move_PNR_from_Queue_feature() throws InterruptedException {

		movePNRFromQueuePopup = new MovePNRFromQueuePopup(driver);
		String str = movePNRFromQueuePopup.listPNR.getText();
		pnr = str.split("\\r?\\n")[4].substring(14, 20);
		System.out.println("PNR IS : "+ pnr);
		movePNRFromQueuePopup.lnkMovePNRFromQueue.click();
		movePNRFromQueuePopup.radioBtnSelectedPNRs.click();
		movePNRFromQueuePopup.txtbxSelectedPNRs.sendKeys("1");
		movePNRFromQueuePopup.txtbxQueueNumber.sendKeys("2");
		movePNRFromQueuePopup.txtbxCategoryNumber.sendKeys("2");
		movePNRFromQueuePopup.btnMovePNRs.click();
		waitMethod(5);
	}

	@When("User retrieves the PNR and clicks on  PNR Queue List link in PNR details page")
	public void user_retrieves_the_PNR_and_clicks_on_PNR_Queue_List_link_in_PNR_details_page() throws InterruptedException {
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@Given("PNR is created and present in more than {int} queues")
	public void pnr_is_created_and_present_in_more_than_queues(int num) throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);


		pnr = homeLeftPanel.createCrypticPNR(driver);
		
		homeLeftPanel.pushIntoMultipleQueues(pnr);
		
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@Then("PNR Queue List pop up should be displayed")
	public void pnr_Queue_List_pop_up_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("PNR Queue List pop up is displayed")
	public void pnr_Queue_List_pop_up_is_displayed() {
		assertEquals(true, pnrQueueListPopup.isPopupDisplayed());
	}

	@When("Next button is displayed as enabled")
	public void next_button_is_displayed_as_enabled() {
		assertEquals(true, pnrQueueListPopup.lnkNext.isEnabled());
	}

	@Then("Next button is displayed as disabled")
	public void next_button_is_displayed_as_disabled() {
		assertEquals(false, pnrQueueListPopup.lnkNext.isEnabled());
	}

	@When("User clicks on the Next button")
	public void user_clicks_on_the_Next_button() {
		pnrQueueListPopup.lnkNext.click();
		// waitMethod(5);
	}

	@When("Previous button is displayed as enabled")
	public void previous_button_is_displayed_as_enabled() {
		assertEquals(true, pnrQueueListPopup.lnkPrevious.isEnabled());
	}

	@Then("Previous button is displayed as disabled")
	public void previous_button_is_displayed_as_disabled() {
		assertEquals(false, pnrQueueListPopup.lnkPrevious.isEnabled());
	}

	@When("User clicks on the Previous button")
	public void user_clicks_on_the_Previous_button() {
		pnrQueueListPopup.lnkPrevious.click();
	}

	@Then("the next set of records should be displayed in the popup")
	public void the_next_set_of_records_should_be_displayed_in_the_popup() {
		System.out.println("To be implemented");
	}

	@When("user navigates to next page in PNR Queue List pop up by clicking on Next button")
	public void user_navigates_to_next_page_in_PNR_Queue_List_pop_up_by_clicking_on_Next_button() {
		pnrQueueListPopup.lnkNext.click();
	}

	@Then("the previous set of records should be displayed in the popup")
	public void the_previous_set_of_records_should_be_displayed_in_the_popup() {
		System.out.println("To be implemented");
	}

	@Given("PNR is created and present in many queues")
	public void pnr_is_created_and_present_in_many_queues() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		homeLeftPanel.pushIntoManyQueues(pnr);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@Given("PNR is created and present in only few queues")
	public void pnr_is_created_and_present_in_only_few_queues() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		homeLeftPanel.pushIntoFewQueues(pnr);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@Given("PNR is created")
	public void pnr_is_created() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@When("User clicks on PNR Queue List link and error is returned by Central system")
	public void user_clicks_on_PNR_Queue_List_link_and_error_is_returned_by_Central_system() {
		pnrDetailsPage.lnkPNRQueueList.click();
		pnrQueueListPopup = new PNRQueueListPopup(driver);
	}

	@Then("the error message should be displayed on the top of the popup")
	public void the_error_message_should_be_displayed_on_the_top_of_the_popup() {
		assertEquals(rtqCrypticResponse, pnrQueueListPopup.getTextResponse());
	}

	@Then("the previous and next button should not be displayed")
	public void the_previous_and_next_button_should_not_be_displayed() {
		assertEquals(false, pnrQueueListPopup.lnkNext.isEnabled());
		assertEquals(false, pnrQueueListPopup.lnkPrevious.isEnabled());
	}

	@Given("The PNR Queue List popup is open")
	public void the_PNR_Queue_List_popup_is_open() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
		
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnrDetailsPage.lnkPNRQueueList.click();
		pnrQueueListPopup = new PNRQueueListPopup(driver);
	}

	@When("user clicks on Close button or X button")
	public void user_clicks_on_Close_button_or_X_button() {
		pnrQueueListPopup.btnClose.click();
	}

	@Given("PNR is retrieved and placed on a Queue using Place PNR on Queue")
	public void pnr_is_retrieved_and_placed_on_a_Queue_using_Place_PNR_on_Queue() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
		
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnrDetailsPage.btnPlaceOnQueue.click();
		waitMethod(13);
		
		placePNROnQueuePopup = new PlacePNROnQueuePopup(driver);
		placePNROnQueuePopup.txtbxQueueNumber.sendKeys("1");
		placePNROnQueuePopup.txtbxcategoryNumber.sendKeys("1");
		placePNROnQueuePopup.btnOk.click();
		waitMethod(4);
	}	
	
	@Given("user deletes PNR from all Queue using {string} link in PNR Details page")
	public void user_deletes_PNR_from_all_Queue_using_link_in_PNR_Details_page(String string) throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);

		pnr = homeLeftPanel.createCrypticPNR(driver);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
		
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnrDetailsPage.lnkDeletePNRFromAllQueues.click();		
		waitMethod(10);
		deletePNRFromAllQueuesPopup = new DeletePNRFromAllQueuesPopup(driver);
		deletePNRFromAllQueuesPopup.btnDelete.click();
		waitMethod(5);
		pnrDetailsPage.lnkHomeTab.click();
		waitMethod(2);
		homeLeftPanel.expandLeftAccordion("Tools", "Cryptic Window");
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		homeLeftPanel.lnkPNRTab.click();
		waitMethod(2);
	}
	
	
	@Given("user deletes PNR from all Queue using {string} button in Queue accordion")
	public void user_deletes_PNR_from_all_Queue_using_button_in_Queue_accordion(String string) throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);
		pnr = homeLeftPanel.createCrypticPNR(driver);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);		
		homeLeftPanel.compressLeftAccordion("Tools");
		waitMethod(2);
		homeLeftPanel.expandLeftAccordion("Queue");
		homeLeftPanel.txtbxDeletePNRFromQueue.sendKeys(pnr);
		waitMethod(2);
		homeLeftPanel.btnDeletePNRFromQueue.click();
		waitMethod(2);
		deletePNRFromAllQueuesQueueAccordionPopup = new DeletePNRFromAllQueuesQueueAccordionPopup(driver);
		deletePNRFromAllQueuesQueueAccordionPopup.btnDelete.click();
		waitMethod(4);		
		homeLeftPanel.compressLeftAccordion("Queue");
		waitMethod(3);
		homeLeftPanel.expandLeftAccordion("Tools", "Cryptic Window");
		waitMethod(3);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);			
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);
	}

	@Given("PNR is accessed in Queue mode")
	public void pnr_is_accessed_in_Queue_mode() throws InterruptedException {
		homeLeftPanel = new HomeLeftPanel(driver);
		pnr = homeLeftPanel.createCrypticPNR(driver);
		homeLeftPanel.pushIntoSingleQueues(pnr);
		rtqCrypticResponse = homeLeftPanel.getRTQResponse(pnr);
		System.out.println(rtqCrypticResponse);		
		homeLeftPanel.compressLeftAccordion("Tools");
		waitMethod(2);
		homeLeftPanel.expandLeftAccordion("Queue");
		
		homeLeftPanel.txtbxQueueNumberToStart.sendKeys("1");
		homeLeftPanel.txtbxCategoryNumberToStart.sendKeys("1");
		homeLeftPanel.btnStartQueue.click();
		waitMethod(15);
	}

	@When("user exits the queue mode and retrieves the PNR")
	public void user_exits_the_queue_mode_and_retrieves_the_PNR() throws InterruptedException {
		
		pnrDetailsPage.closePNR();
		//homeLeftPanel.expandLeftAccordion("Tools", "Cryptic Window");
		queueSet = homeLeftPanel.getQueueSet(pnr);
		System.out.println(queueSet.stream().anyMatch(str -> "002".equals(str.substring(20, 23)) && "001".equals(str.substring(27, 30))));
		System.out.println(queueSet.stream().anyMatch(str -> "001".equals(str.substring(20, 23)) && "001".equals(str.substring(27, 30))));
		
		homeTopPanel = new HomeTopPanel(driver);
		homeTopPanel.retrievePNR(pnr);		
	}

	
	@When("user Delays the PNR by accessing Delay PNR feature and exits queue")
	public void user_Delays_the_PNR_by_accessing_Delay_PNR_feature_and_exits_queue() throws InterruptedException {
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnr = pnrDetailsPage.getPNRNumber();
		pnrDetailsPage.btnDelayPNR.click();
		waitMethod(4);
		delayPNRPopup = new DelayPNRPopup(driver);
		delayPNRPopup.delayPNR();
	}

	@When("user retrieves the PNR")
	public void user_retrieves_the_PNR() throws InterruptedException {
		homeLeftPanel.expandLeftAccordion("Tools", "Cryptic Window");
		queueSet = homeLeftPanel.getQueueSet(pnr);
		System.out.println(queueSet.stream().anyMatch(str -> "002".equals(str.substring(20, 23)) && "001".equals(str.substring(27, 30))));
		System.out.println(queueSet.stream().anyMatch(str -> "001".equals(str.substring(20, 23)) && "001".equals(str.substring(27, 30))));
		homeTopPanel = new HomeTopPanel(driver);		
		homeTopPanel.retrievePNR(pnr);
	}

	@Then("this list should include the Queue in which the PNR has been delayed")
	public void this_list_should_include_the_Queue_in_which_the_PNR_has_been_delayed() {

	}	
	
	
	@Then("this list should include the queue to which the PNR has been placed")
	public void this_list_should_include_the_queue_to_which_the_PNR_has_been_placed() {

	}

	@When("PNR is placed on a Queue using {string} feature by selecting Remove from Queue option")
	public void pnr_is_placed_on_a_Queue_using_feature_by_selecting_Remove_from_Queue_option(String string) throws InterruptedException {
		pnrDetailsPage = new PNRDetailsPage(driver);
		pnr = pnrDetailsPage.getPNRNumber();
		pnrDetailsPage.btnPlaceOnQueue.click();
		waitMethod(10);
		placePNROnQueuePopup = new PlacePNROnQueuePopup(driver);
		placePNROnQueuePopup.txtbxQueueNumber.sendKeys("2");
		placePNROnQueuePopup.txtbxcategoryNumber.sendKeys("1");
		placePNROnQueuePopup.btnOk.click();
		waitMethod(7);
	}

	@Then("the old queue in which PNR was accessed in queue mode should not be in the list")
	public void the_old_queue_in_which_PNR_was_accessed_in_queue_mode_should_not_be_in_the_list() {

	}

	
	
	@Then("PNR Queue List popup is closed")
	public void pnr_Queue_List_popup_is_closed() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Given("PNR list is displayed")
	public void pnr_list_is_displayed() {
		homeLeftPanel = new HomeLeftPanel(driver);
		homeLeftPanel.expandLeftAccordion("Queue");
		pnrListPage = new PNRListPage(driver);
		pnrListPage.txtbxQueueNumber.sendKeys("1");
		pnrListPage.txtbxCategorynumber.sendKeys("6");
		pnrListPage.btnDisplayPNRList.click();
	}

	@When("user clicks on next")
	public void user_clicks_on_next() {
		System.out.println(pnrListPage.lnkNext.isEnabled());
		System.out.println(pnrListPage.lnkPrevious.isEnabled());
		System.out.println(pnrListPage.lnkPrevious.getText());
		System.out.println(pnrListPage.lnkPrevious.getAttribute("class"));
	}

	@Then("next list is displayed")
	public void next_list_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}
