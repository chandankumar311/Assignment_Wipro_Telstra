package com.Utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public static WebDriverWait waitForMoment(WebDriver ldriver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return wait;
	}
	
	public static void scrollToView(WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("window.scrollBy(0,-150)", "");
	}
	
	public static void scrollToMiddleOfPage(){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void scrollToBottomOfPage(){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		//executor.executeScript("window.scrollTo(window.pageYOffset,document.body.scrollHeight);");
	}
	
	public static void switchToNewTab() {
		try {
			Set<String> winSet = driver.getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			String newTab = winList.get(winList.size() - 1);
			System.out.println("Window Handle Size: " + winList.size());
			System.out.println(driver.getCurrentUrl());
			System.out.println(newTab);
			driver.switchTo().window(newTab);
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitFor2Sec() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
			
		}
	}
	
	public static String createUniqueFirstname() {
		String varUniqFirstName = "FIRST" + RandomStringUtils.random(3,"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		return varUniqFirstName;
	}
	
	public static String createUniqueLastname() {
		String varUniqLastName = "LAST" + RandomStringUtils.random(3,"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		return varUniqLastName;
	}
	
	public static Date getCurrentTime() {
		final Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
}
