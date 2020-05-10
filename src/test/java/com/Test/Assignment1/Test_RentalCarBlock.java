package com.Test.Assignment1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.RentalCarBlock;
import com.Utility.TestBase;

@Listeners(com.Utility.TestListener.class)
public class Test_RentalCarBlock extends TestBase{
	
	RentalCarBlock rentalCarBlock;

	public Test_RentalCarBlock() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		rentalCarBlock = new RentalCarBlock();
	}

	@Test(priority = 1, description = "This test case will automate top rental car.")
	public void selectDiffCarType() {
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Controlgroup"), "User is not on Controlgroup page.");
		
		Select sel = new Select(rentalCarBlock.getRentalCarTypeTop());
		System.out.println("First Selected option: " + sel.getFirstSelectedOption().getAttribute("innerHTML"));
		List<WebElement> options = sel.getOptions();
		List<String> optionText = new ArrayList<String>();
		
		for(WebElement ele : options) {
			String text = ele.getAttribute("innerHTML").trim();
			optionText.add(text);
		}
		System.out.println("All option in dropdown are: \n" + optionText);
		
		/*for(String option : optionText) {
			sel.selectByVisibleText(option);
		}*/
		
		for(int i=0; i<options.size(); i++) {
			//sel.selectByIndex(i);
		}
		
	}
	
	@Test(priority = 2, description = "This test case will automate top rental car.")
	public void selectDiffCarType_Positive() {
		
		rentalCarBlock.getStatndardRBTop().click();
		rentalCarBlock.getInsuranceCBTop().click();
		rentalCarBlock.getAutomaticRBTop().click();
		
		for(int i=0; i<=10; i++) {
			rentalCarBlock.getUpSpinnerTop().click();
		}
		
		for(int i=0; i<=10; i++) {
			rentalCarBlock.getDownSpinnerTop().click();
		}
		
		rentalCarBlock.getBookNowBtnTop().click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("==========Browser Closed==========");
	}

}
