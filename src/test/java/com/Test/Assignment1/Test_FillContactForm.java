package com.Test.Assignment1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.FillContactForm;
import com.Utility.ExcelDataConfig;
import com.Utility.TestBase;

@Listeners(com.Utility.TestListener.class)
public class Test_FillContactForm extends TestBase{

	FillContactForm fillContactForm;
	ExcelDataConfig excelData;

	public Test_FillContactForm() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("contactFormURL");
		fillContactForm = new FillContactForm();
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	}

	@Test(priority = 2, description = "This test case will fill the contact Form")
	public void submitContactForm() {
		
		String title = driver.getTitle();
		Reporter.log("Title of page: " + title);
		Assert.assertTrue(title.contains("contact form"), "User is not on Contact Form page.");
		
		fillContactForm.setFirstName(excelData.getData(0, 1, 0));
		fillContactForm.setLastName(excelData.getData(0, 1, 1));
		fillContactForm.setCountryName(excelData.getData(0, 1, 2));
		fillContactForm.setSubject(excelData.getData(0, 1, 3));
		fillContactForm.clickOnSubmitBtn();
	}

	@Test(priority = 1, description = "This test case will open the Google link in new TAB")
	public void click_GoogleLink() {
		
		Actions action = new Actions(driver);
		
		for(int i=0; i<fillContactForm.googleLinks.size(); i++) {
			WebElement  link = fillContactForm.googleLinks.get(i);
			
			if (link.getText().contains("Google Link")) {
				action.pause(2000).contextClick(link).perform();
				
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);
					robot.keyPress(KeyEvent.VK_T);
					robot.keyRelease(KeyEvent.VK_T);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				
				/*action.pause(2000).sendKeys(Keys.CONTROL).click(link).release(link).sendKeys(Keys.CONTROL).pause(2000)
						.perform();*/
				continue;
			}
			
			/*
			Set<String> tabs = driver.getWindowHandles();
			String parentTab = driver.getWindowHandle();
			System.out.println("All tabs: " + tabs);
			System.out.println("Parent Tab: " + parentTab);*/
		}
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		Reporter.log("==========Browser Closed==========");
		System.out.println("==========Browser Closed==========");
	}

}
