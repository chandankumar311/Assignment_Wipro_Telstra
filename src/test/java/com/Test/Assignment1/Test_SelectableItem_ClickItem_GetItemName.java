package com.Test.Assignment1;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.SelectableItem_ClickItem_GetItemName;
import com.Utility.TestBase;

@Listeners(com.Utility.TestListener.class)
public class Test_SelectableItem_ClickItem_GetItemName extends TestBase {
	
	SelectableItem_ClickItem_GetItemName selectable;
	
	public Test_SelectableItem_ClickItem_GetItemName() {
		
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("selectableURL");
		selectable = new SelectableItem_ClickItem_GetItemName();
	}
	
	@Test(priority = 1,description = "This test case will click on selectable link.")
	public void click_SelectableLink(){

		selectable.clickOnselectablelink();
		
		String title = driver .getTitle();
		Assert.assertTrue(title.contains("Selectable"), "User is not on Selectable link");
	}
	
	@Test(priority = 2,description = "This test case will click on items and get the text")
	public void click_Item(){
		
		String itemName = "";
		
		for(WebElement item : selectable.items) {
			item.click();
			itemName = itemName + item.getText() + ", ";
		}
		Reporter.log("Item Name: " + itemName);
		System.out.println("Item Name: " + itemName);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		Reporter.log("==========Browser Closed==========");
	}

}
