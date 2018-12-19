package com.amadeus.selenium.ardNew.test.BDD.pageObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.amadeus.selenium.ardNew.utils.FileUtils;
import com.amadeus.selenium.utils.CheckUtils;

import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.populateCrypticCommands;
import static com.amadeus.selenium.ardNew.test.BDD.utiMethods.HelperMethods.waitMethod;

public class HomeLeftPanel {
	public HomeLeftPanel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private String pnrRegExp = "(IGNORED|IGNORADO|ON QUEUE ) - (.*)";
	
	@FindBy(how = How.CSS, using = ".textResponse>pre>code")
	public List<WebElement> crypticResponse;

	@FindBy(how = How.CSS, using = "[id*='_shellWindow_top_left_'][id*='command'][class=command]")
	public List<WebElement> commandCount;

	@FindBy(how = How.CSS, using = "[id$='ardAccordion_ardMenuAccordion_id'] dt")
	public List<WebElement> menuItems;

	@FindBy(how = How.CSS, using = "[id*='ygtvlabel']")
	public List<WebElement> subMenuItems;

	@FindBy(how = How.CSS, using = "[id*='_shellWindow_top_left_'][class='cmdPromptInput']")
	public WebElement txtbxCrypticPrompt;
	
	@FindBy(how = How.CSS,using = "#equeue_movePNRLink")
	public WebElement lnkMovePNRFromQueue;	
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_QUEUE_NUMBER_id_input")
	public WebElement txtbxMovePNRQueueNumber;
	
	@FindBy(how = How.CSS,using="#equeue_PNRMove_CATEGORY_id_input")
	public WebElement txtbxMovePNRCategoryNumber;
	
	@FindBy(how = How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Move PNRs')]")
	public WebElement btnMovePNR;
	
	@FindBy(how = How.CSS,using="body.printDisabled:nth-child(2) div.uic-ALF div.apftaskmgr div.tasks:nth-child(3) ul.uicTaskbar li.file div.b div.c > span.uicTaskbarText")
	public WebElement lnkPNRTab;
	
	@FindBy(how=How.XPATH,using="//input[@id='equeue_queueMenu_recLoc_id_input']")
	public WebElement txtbxDeletePNRFromQueue;
	
	@FindBy(how=How.XPATH,using="//span[contains(@class,'uicButtonBd')]//strong[contains(text(),'Delete PNR from queues')]")
	public WebElement btnDeletePNRFromQueue;
	
	@FindBy(how = How.XPATH,using="//input[@id='equeue_queueMenu_queueNumber_id_input']")
	public WebElement txtbxQueueNumberToStart;
	
	@FindBy(how = How.XPATH,using="//input[@id='equeue_queueMenu_categoryNumber_id_input']")
	public WebElement txtbxCategoryNumberToStart;
	
	@FindBy(how = How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Start Queue')]")
	public WebElement btnStartQueue;
	
	@FindBy(how = How.XPATH,using="//span[@class='uicButtonBd']//strong[contains(text(),'Display PNR List')]")
	public WebElement btnDisplayPNRList; 
	
	public void enterCrypticCommand(String cmd) throws InterruptedException {
		txtbxCrypticPrompt.sendKeys(cmd);
		txtbxCrypticPrompt.sendKeys(Keys.RETURN);
		waitMethod(2);
	}

	public void expandLeftAccordion(String menu, String subMenu) {
		for (WebElement elem : menuItems) {
			if (elem.isDisplayed()) {
				String txt = elem.getText();
				if (elem.getText().contains(menu)) {
					if (elem.getText().contains("closed"))
						elem.click();
					break;
				}
			}
		}

		for (WebElement elem : subMenuItems) {
			if (elem.isDisplayed()) {
				String txt = elem.getText();
				if (elem.getText().contains(subMenu)) {
					elem.click();
					break;
				}
			}
		}
	}
	

	
	public void expandLeftAccordion(String menu) {
		for (WebElement elem : menuItems) {
			if (elem.isDisplayed()) {
				String txt = elem.getText();
				if (elem.getText().contains(menu)) {
					if (elem.getText().contains("closed"))
						elem.click();
					break;
				}
			}
		}
	}

	public String ReturnCrypticWindowResponse(int iResponseLine) {
		String sResponse = null;
		if (crypticResponse.isEmpty()) {
			return sResponse;
		}
		WebElement Elem = crypticResponse.get(iResponseLine);
		sResponse = Elem.getText().trim();
		return sResponse;
	}

	public int ReturnCrypticCommandCount() {
		int iCount = 0;
		if (!commandCount.isEmpty()) {
			iCount = commandCount.size();
			return iCount;
		}
		return iCount;
	}

	public String PNRnumber() {
		String pnr = "";
		String sResponse = ReturnCrypticWindowResponse(ReturnCrypticCommandCount() - 1).trim();
		System.out.println("Cryptic Response " + sResponse);
		int index = sResponse.indexOf("\n");
		if (index > 0) {
			sResponse = sResponse.substring(0, index);
		}
		Pattern p = Pattern.compile(pnrRegExp);
		Matcher m = p.matcher(sResponse);
		if (m.matches()) {
			pnr = m.group(2);
			System.out.println("PNR Created " + pnr);
		}
		return pnr;
	}

	public String createCrypticPNR(WebDriver driver) throws InterruptedException {
		expandLeftAccordion("Tools", "Cryptic Window");
		
	    ArrayList<String> lsCommand = new ArrayList<String>();
	    lsCommand = populateCrypticCommands(lsCommand);

	    for(int i = 0; i<lsCommand.size();i++) {
	    	enterCrypticCommand(lsCommand.get(i));
	    }
	    
		return PNRnumber();
	}
	
	public void pushIntoMultipleQueues(String pnr) throws InterruptedException {
		String str;
		str = "QMxc1/xc2/xc3/xc4/xc5/xc6";
		for(int i=49;i<54;i++) {
			enterCrypticCommand("rt" + pnr);
			enterCrypticCommand(str.replace('x',(char)i));
		}
	}

	public void pushIntoSingleQueues(String pnr) throws InterruptedException {
		enterCrypticCommand("rt " + pnr);
		enterCrypticCommand("qe1c1");
	}

	public String getRTQResponse(String pnr) throws InterruptedException {
		//enterCrypticCommand("ig");
		enterCrypticCommand("rt" + pnr);
		enterCrypticCommand("rtq");
		String sResponse = ReturnCrypticWindowResponse(ReturnCrypticCommandCount() - 1).trim();
		System.out.println("Cryptic Response " + sResponse);
		return sResponse;
	}
	
	public Set<String> getQueueSet(String pnr) throws InterruptedException{
		Set<String> queueSet = new HashSet<>();		
		boolean hasNext = false;		
		String[] arr = getRTQResponse(pnr).split("\\r?\\n");		
		addToSet(queueSet,arr);
		
		while(hasNext(arr)){			
			arr = getNextRTQResponse(pnr).split("\\r?\\n");						
			addToSet(queueSet,arr);
		}			

		return queueSet;
	}
	
	
	
	private String getNextRTQResponse(String pnr) throws InterruptedException {		
		enterCrypticCommand("md");
		String sResponse = ReturnCrypticWindowResponse(ReturnCrypticCommandCount() - 1).trim();
		System.out.println("Cryptic Response " + sResponse);
		return sResponse;
	}

	public boolean hasNext(String[] arr) {
		int len = arr.length;
		return arr[len-1].equals(")>");
	}

	public void pushIntoManyQueues(String pnr) throws InterruptedException {
		String str;
		str = "QMxc1/xc2/xc3/xc4/xc5/xc6";
		for(int i=49;i<55;i++) {
			enterCrypticCommand("rt" + pnr);
			enterCrypticCommand(str.replace('x',(char)i));
		}		
	}
		
	public static Set<String> addToSet(Set<String> queueSet,String[] arr, int start, int end) {
		for(;start<=end;start++) {
			queueSet.add(arr[start]);
		}		
		return queueSet ;
	}
	
	public Set<String> addToSet(Set<String> queueSet,String[] arr){
		int start,end;
		int len = arr.length;
		
		if(arr[0].startsWith("------------------"))
			start = 4;
		else
			start = 0;
		
		if(hasNext(arr))
			end = len - 2;
		else
			end = len - 1;
		
		for(;start<=end;start++) {
			queueSet.add(arr[start]);
		}
		
		return queueSet;
	}

	public void pushIntoFewQueues(String pnr) throws InterruptedException {
		String str;
		str = "QMxc1/xc2/xc3/xc4/xc5/xc6";
		for(int i=49;i<52;i++) {
			enterCrypticCommand("rt" + pnr);
			enterCrypticCommand(str.replace('x',(char)i));
		}				
	}

	public void compressLeftAccordion(String menu) {
		for (WebElement elem : menuItems) {
			if (elem.isDisplayed()) {
				String txt = elem.getText();
				if (elem.getText().contains(menu)) {					
					elem.click();
					break;
				}
			}
		}
	}

	
	
	

}
