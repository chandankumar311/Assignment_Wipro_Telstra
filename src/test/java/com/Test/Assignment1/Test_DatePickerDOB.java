package com.Test.Assignment1;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.DatePickerDOB;
import com.Utility.ExcelDataConfig;
import com.Utility.TestBase;
import com.Utility.TestUtil;

@Listeners(com.Utility.TestListener.class)
public class Test_DatePickerDOB extends TestBase{
	
	DatePickerDOB datePicker;
	ExcelDataConfig excelData;

	public Test_DatePickerDOB() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("DatePickerURL");
		datePicker = new DatePickerDOB();
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	
	
	}

	@Test(priority = 1, description = "This test case will select the DOB")
	public void selectingDOB() throws Exception {
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Datepicker"), "User is not on Datepicker page.");
		
		// clicking on date textbox
		datePicker.ClickOndateTextBox();
		
		System.out.println("Today: " + TestUtil.getCurrentTime());
		
		String day = excelData.getData(0, 1, 4);		
		String month = excelData.getData(0, 1, 5);
		String year = excelData.getData(0, 1, 6);
		
		for(int i=2020; i>=1660; i--) {
			if(! datePicker.getYear().getText().equals(year)) {
				datePicker.clickOnPrevious();
				continue;
			}
			
			if(! datePicker.getMonth().getText().equals(month)) {
				datePicker.clickOnPrevious();
				continue;
			}
			
			for (int j = 0; j < datePicker.tableDates.size(); j++) {
				
				if (datePicker.getMonth().getText().equals(month) && datePicker.getYear().getText().equals(year)) {
					String tableDate = datePicker.tableDates.get(j).getText();
					if (tableDate.equals(day)) {
						System.out.println("Date selected: " + tableDate);
						datePicker.tableDates.get(j).click();
						break;
					}
				}

			}
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("==========Browser Closed==========");
	}

}
