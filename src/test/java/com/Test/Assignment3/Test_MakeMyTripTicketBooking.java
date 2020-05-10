package com.Test.Assignment3;

/*
Assignment 3:							
Automate the below mentioned site for booking and reviewing it							
https://www.makemytrip.com/							
Step 1: Launch Make my trip website ( makemytrip.com)							
Step 2: Select any one option( Oneway ,Roundtrip,Multi City)							
Step 3: Select From & To							
Step 4: Select the Departure date in Jan 2020							
Step 5: Search for the cheapest price and click on Book now button							
Step 6: Review the selection in the review page (please note need not submit booking
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment3.MakeMyTripTicketBooking;
import com.Utility.ExcelDataConfig;
import com.Utility.TestBase;

@Listeners(com.Utility.TestListener.class)
public class Test_MakeMyTripTicketBooking extends TestBase {

	MakeMyTripTicketBooking makeMyTripTicketBooking;
	ExcelDataConfig excelData;

	public Test_MakeMyTripTicketBooking() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("MakeMyTripTicketBooking");
		makeMyTripTicketBooking = new MakeMyTripTicketBooking();
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	}

	@Test(priority = 1, description = "This test case will verify login page.")
	public void verifyLoginPage() {

		String title = driver.getTitle();
		Assert.assertTrue(title.contains("MakeMyTrip"), "User is not on MakeMyTrip login page.");

		String loginOrCreateAccountBtnTxt = makeMyTripTicketBooking.getLoginOrCreateAccountBtn().getText().trim();
		Assert.assertTrue(loginOrCreateAccountBtnTxt.contains("Login or Create Account"),
				"Sorry user is not on login page.");

		System.out.println("User lending to login page successfully.");
	}

	@Test(priority = 2, dependsOnMethods = {
			"verifyLoginPage" }, description = "This test case will select trip types.")
	public void clickTripTypes() {
		makeMyTripTicketBooking.getSelectTripTypeRadio().click();
		System.out.println("User clicked on Round Trip radio button.");
	}

	@Test(priority = 3, dependsOnMethods = {
			"clickTripTypes" }, description = "This test case will set the From and To City.")
	public void enterFromAndToCity() {
		String fromCity = excelData.getData(1, 1, 0).toLowerCase().trim();
		String toCity = excelData.getData(1, 1, 1).toLowerCase().trim();

		makeMyTripTicketBooking.getFromCityTab().click();
		makeMyTripTicketBooking.getFromCityTextBox().sendKeys(fromCity, Keys.ENTER);
		
		new Actions(driver).pause(6000).sendKeys(Keys.DOWN, Keys.ENTER).perform();

		/*// Selecting FromCity from dropdown
		for (WebElement singleFromCity : makeMyTripTicketBooking.selectFromCity()) {
			String fromCityText = singleFromCity.getText().toLowerCase().trim();
			if (fromCityText.contains(fromCity)) {
				singleFromCity.click();
				System.out.println("User selected From City." + fromCityText);
				break;
			}
		}*/
		
		makeMyTripTicketBooking.getToCityTab().click();
		makeMyTripTicketBooking.getToCityTextBox().sendKeys(toCity, Keys.ENTER);
		new Actions(driver).pause(6000).sendKeys(Keys.DOWN, Keys.ENTER).perform();
		
		// Selecting To city from dropdown
		/*for (WebElement singleToCity : makeMyTripTicketBooking.selectToCity()) {
			String toCityText = singleToCity.getText().toLowerCase().trim();
			System.out.println("City Name: " + toCityText);
			if (toCityText.contains(toCity)) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(singleToCity));
				singleToCity.click();
				System.out.println("User selected To City." + toCityText);
				break;
			}
		}*/
	}
	
	@Test(priority = 4, dependsOnMethods = {
			"enterFromAndToCity" }, description = "This test case will select Departure Date.")
	public void SelectDepartureDate() {
		String departureDayExl = excelData.getData(1, 1, 2).toLowerCase().trim();
		String departureMonthExl = excelData.getData(1, 1, 3).toLowerCase().trim();
		String departureYearExl = excelData.getData(1, 1, 4).toLowerCase().trim();
		
		for (int i = 0; i <= makeMyTripTicketBooking.visibleMonthNameList.size(); i++) {
			WebElement actualMonth = makeMyTripTicketBooking.visibleMonthNameList.get(0);
			String actualMonthText = actualMonth.getText().toLowerCase().trim();

			if (actualMonthText.contains(departureMonthExl) && actualMonthText.contains(departureYearExl)) {

				for (int j = 0; j < makeMyTripTicketBooking.visibleDateFirstCalanderList.size(); j++) {
					
					WebElement date = makeMyTripTicketBooking.visibleDateFirstCalanderList.get(j);
					String actualDateText = date.getText().toLowerCase().trim();
					if (actualDateText.equals(departureDayExl)) {
						date.click();
						break;
					}
				}
				
				System.out.println("Size of visible calander: " + makeMyTripTicketBooking.visibleMonthNameList.size());
				System.out.println("Size of dates: " + makeMyTripTicketBooking.visibleDateFirstCalanderList.size());
				
				break;
				
			} else if (! actualMonthText.contains(departureMonthExl) || actualMonthText.contains(departureYearExl)) {
				makeMyTripTicketBooking.nextMonthNavBtn.click();
			}
		}
					
	}
	
	@Test(priority = 5, dependsOnMethods = {
			"SelectDepartureDate" }, description = "This test case will select Return Date.")
	public void selectReturnDate() {
		String returnDayExl = excelData.getData(1, 1, 5).toLowerCase().trim();
		String returnMonthExl = excelData.getData(1, 1, 6).toLowerCase().trim();
		String returnYearExl = excelData.getData(1, 1, 7).toLowerCase().trim();
		String actualReturnToday = makeMyTripTicketBooking.returnCurrentDate.getText().toLowerCase().trim();
		
		for (int i = 0; i <= 12; i++) {
			WebElement actualMonth = makeMyTripTicketBooking.visibleMonthNameList.get(0);
			String actualMonthText = actualMonth.getText().toLowerCase().trim();

			if (actualMonthText.contains(returnMonthExl) && actualMonthText.contains(returnYearExl)) {
				
				for (int j = 0; j < makeMyTripTicketBooking.visibleDateFirstCalanderList.size(); j++) {
					WebElement date = makeMyTripTicketBooking.visibleDateFirstCalanderList.get(j);
					String actualDateText = date.getText().toLowerCase().trim();
					if (actualDateText.equals(returnDayExl)) {
						date.click();
						break;
					}
				}
				
				/*String actualReturnToday_Modified = actualReturnToday.replace(" ", "");
				String returnDateExl = returnDayExl + returnMonthExl + returnYearExl.toLowerCase().trim();
				System.out.println("Actual Return Date: " + actualReturnToday_Modified);
				System.out.println("Excel Return Date: " + returnDateExl);
				
				if(actualReturnToday_Modified.equals(returnDateExl)) {
					System.out.println("Departure date selected: " + actualReturnToday_Modified);
				}
				
				System.out.println("Size of visible calander: " + makeMyTripTicketBooking.visibleMonthNameList.size());
				System.out.println("Size of dates: " + makeMyTripTicketBooking.visibleDateFirstCalanderList.size());
				*/
				break;
				
			} else if (! actualMonthText.contains(returnMonthExl) || actualMonthText.contains(returnYearExl)) {
				makeMyTripTicketBooking.nextMonthNavBtn.click();
			}
		}

	}
	
	@Test(priority = 6, dependsOnMethods = {
			"selectReturnDate" }, description = "This test case will click on Search link and sort Departure price.")
	public void clickSearchLinkAndSortDepartureByPrice() {
		makeMyTripTicketBooking.clickSearchLink();
		makeMyTripTicketBooking.sortDepartureByPrice();
	}
	
	@Test(priority = 7, dependsOnMethods = {
			"clickSearchLinkAndSortDepartureByPrice" }, description = "This test case will sort Return price and Click on Book Now button.")
	public void SortReturnByPriceAndClickBookNowBTN() {
		makeMyTripTicketBooking.sortReturnByPrice();
		makeMyTripTicketBooking.ClickOnBookNowBTN();
	}
	
	@Test(priority = 8, dependsOnMethods = {
			"SortReturnByPriceAndClickBookNowBTN" }, description = "This test case will click on continue button for review.")
	public void clickContinueBTNforReview() {
		makeMyTripTicketBooking.ClickOnContinueBTN();
	}
	
	@Test(priority = 9, dependsOnMethods = {
			"clickContinueBTNforReview" }, description = "This test case will verify the review page.")
	public void VerifyReviewPage() {
		makeMyTripTicketBooking.validateReviewPage();
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("==========Browser Closed==========");
	}

}
