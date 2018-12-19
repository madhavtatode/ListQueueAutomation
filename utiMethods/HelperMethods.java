package com.amadeus.selenium.ardNew.test.BDD.utiMethods;

import java.util.ArrayList;
import static com.amadeus.selenium.ardNew.test.BDD.stepDefinition.Test_Steps.*;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.amadeus.selenium.ardNew.test.BDD.utilities.*;

public class HelperMethods {
	public static void waitMethod(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	public static boolean waitForOverlayLoading(int timeOut) throws InterruptedException {
		// wait for an element condition
		ExpectedCondition<Boolean> condition = new WaitMultipleOverlayCondition();
		WebDriverWait wait = new WebDriverWait(driver, timeOut);		
		Boolean waitResult = wait.until(condition);		
		waitMethod(4);
		if (waitResult != null) {
			return waitResult.booleanValue();
		}
		return false;
	}

	public static boolean waitForCondition(ExpectedCondition<Boolean> condition, int timeout) throws TimeoutException {
		// wait for an element condition
		Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
		Boolean waitResult = wait.until(condition);
		if (waitResult != null) {
			return waitResult.booleanValue();
		}
		return false;
	}

	public static boolean waitForElementVisible(By eltLocator, int timeout) {
		// wait for an element not visible
		try {
			return waitForCondition(new WaitElementDisplayCondition(eltLocator, true), timeout);
		} catch (TimeoutException te) {
			// Report the timeout

		}
		return false;
	}

	public static boolean waitForElementEnable(By eltLocator, int timeout) {
		// wait for an element enable
		try {
			return waitForCondition(new WaitElementEnableCondition(eltLocator, true), timeout);
		} catch (TimeoutException te) {

		}
		return false;
	}

	public static void pageSync(By locator, int timeOut) throws InterruptedException {
		System.out.println("Page Sync overlay started : " + java.time.LocalTime.now());
		waitForOverlayLoading(120);
		System.out.println("Page sync overlay ended and visible started : " + java.time.LocalTime.now());
		waitForElementVisible(locator, timeOut);
		System.out.println("visible ended and sync overlay started : " + java.time.LocalTime.now());
		waitForOverlayLoading(240);
		System.out.println("sync overlay ended and  enable started: " + java.time.LocalTime.now());
		waitForElementEnable(locator, timeOut);
		System.out.println("enable ended : " + java.time.LocalTime.now());
	}

	public static ArrayList<String> populateCrypticCommands(ArrayList<String> lsCommand) {
		lsCommand.add("NM1SEP/TESTERA(ADT)");
		lsCommand.add("an30decsinbkk");
		lsCommand.add("ss1y1");
		lsCommand.add("AP");
		lsCommand.add("TKOK");
		lsCommand.add("Rf Test");
		lsCommand.add("ER");
		lsCommand.add("ER");
		lsCommand.add("IG");
		return lsCommand;
	}
}
