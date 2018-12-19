package com.amadeus.selenium.ardNew.test.BDD.pageObjects;
import static com.amadeus.selenium.ardNew.test.BDD.stepDefinition.Test_Steps.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

/*		
	private static By LOC_TXTBX_USERNAME = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/span[1]/input[1]");
	private static By LOC_TXTBX_PASSWORD = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[3]/input[1]");
	private static By LOC_BTN_LOGIN = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[7]/button[1]/span[2]/strong[1]");
*/
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/span[1]/input[1]")
	@FindBy(how=How.ID,using="eusermanagement_login_logi_USER_ALIAS_id_input")
	public WebElement txtbxUserName;
	
	
	//@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[3]/input[1]")
	@FindBy(how=How.ID,using="eusermanagement_login_logi_PASSWORD_id_input")
	public WebElement txtbxPassword;
	
	//@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[7]/button[1]/span[2]/strong[1]")
	@FindBy(how = How.CSS,using="#eusermanagement_login_logi_signin_id .uicButtonBd strong")
	public WebElement btnLogin;
	
	@FindBy(how = How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'OK')]")
	public WebElement btnOKPopup;
	
	public void login() throws InterruptedException {
		String user;
		String passwd;
		String url = driver.getCurrentUrl();
		if(url.contains("SQ")) {
			user = "ARDTEST1";
			passwd = "Amadeus02";
		}
		else {
			user = "1ATEST002";
			passwd = "Amadeus02";
		}
		txtbxUserName.sendKeys(user);
		txtbxPassword.sendKeys(passwd);
		btnLogin.click();		
		if(url.contains("SQ")) {
			Thread.sleep(2000);
			btnOKPopup.click();
		}
	}
	
	

}
