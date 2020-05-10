package com.Assignment3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utility.TestBase;
import com.Utility.TestUtil;

public class MakeMyTripTicketBooking extends TestBase{

	// Page Factory - OR:
	@FindBy(xpath = "//li[@data-cy='account']/div/p")
	private WebElement loginOrCreateAccountBtn;
	
	@FindBy(xpath = "//li[contains(text(),'Round Trip')]/span")
	private WebElement selectTripTypeRadio;
	
	@FindBy(css = "input#fromCity")
	private WebElement fromCityTab;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromCityTextBox;
	
	@FindBy(css = "label[for='toCity'] input#toCity")
	private WebElement toCityTab;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toCityTextBox;
	
	@FindBy(xpath = "//ul[@role='listbox']/descendant::p[contains(@class,'blackText')]")
	private List<WebElement> fromCityListDD;
	
	@FindBy(xpath = "//ul[@role='listbox']/descendant::p[contains(@class,'blackText')]")
	private List<WebElement> toCityListDD;
	
	@FindBy(xpath = "(//span[contains(@class,'selectedDateField')])[last()-1]")
	public WebElement departureCurrentDate;
	
	@FindBy(xpath = "(//span[contains(@class,'selectedDateField')])[last()]")
	public WebElement returnCurrentDate;
	
	@FindBy(xpath = "//span[@aria-label='Next Month']")
	public WebElement nextMonthNavBtn;
	
	@FindBy(xpath = "//div[@class='DayPicker-Caption']/div")
	public List<WebElement> visibleMonthNameList;
	
	@FindBy(xpath = "(//div[@class='DayPicker-Body'])[1]/descendant::div[@class='dateInnerCell']/p")
	public List<WebElement> visibleDateFirstCalanderList;
	
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchLink;
	
	@FindBy(css = "button#sorter_btn_onward")
	private WebElement departureSortBTN;
	
	@FindBy(css = "button#sorter_btn_return")
	private WebElement returnSortBTN;
	
	@FindBy(xpath = "(//ul[contains(@class,'dropdown-menu')])[last()-1]/descendant::span[text()='Price']")
	private WebElement sortDeparturePriceL2H;
	
	@FindBy(xpath = "(//ul[contains(@class,'dropdown-menu')])[last()]/descendant::span[text()='Price']")
	private WebElement sortreturnPriceL2H;
	
	@FindBy(xpath = "((//div[@id='ow-domrt-jrny']//label)[1]//span)[1]")
	private WebElement firstSortedDepartureFlight;
	
	@FindBy(xpath = "((//div[@id='rt-domrt-jrny']//label)[1]//span)[1]")
	private WebElement firstSortedReturnFlight;
	
	@FindBy(xpath = "//button[text()='Book Now']")
	private WebElement bookNowBTN;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBTN;
	
	@FindBy(xpath = "//h4[contains(@class,'headerTitle')]")
	private WebElement reviewForBookingText;
	
	@FindBy(xpath = "//label[@for='charity']/descendant::span[@class='check']")
	private WebElement charityCB;
	
	@FindBy(id = "review-continue")
	private WebElement continueBTNReview;
	
	// Initializing the Page Objects:
	public MakeMyTripTicketBooking(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public WebElement getLoginOrCreateAccountBtn() {
		return loginOrCreateAccountBtn;
	}
	
	public WebElement getSelectTripTypeRadio() {
		return selectTripTypeRadio;
	}
	
	public WebElement getFromCityTab() {
		return fromCityTab;
	}
	
	public WebElement getFromCityTextBox() {
		return fromCityTextBox;
	}
	
	public WebElement getToCityTab() {
		return toCityTab;
	}
	
	public WebElement getToCityTextBox() {
		return toCityTextBox;
	}
	
	public List<WebElement> selectFromCity() {
		return fromCityListDD;
	}
	
	public List<WebElement> selectToCity() {
		return toCityListDD;
	}
	
	public void clickSearchLink() {
		TestUtil.scrollToView(searchLink);
		searchLink.click();
	}
	
	public void sortDepartureByPrice() {
		TestUtil.waitForMoment(driver, departureSortBTN);
		departureSortBTN.click();
		TestUtil.waitForMoment(driver, sortDeparturePriceL2H);
		sortDeparturePriceL2H.click();
		TestUtil.waitForMoment(driver, firstSortedDepartureFlight);
		firstSortedDepartureFlight.click();
	}
	
	public void sortReturnByPrice() {
		TestUtil.waitForMoment(driver, returnSortBTN);
		returnSortBTN.click();
		TestUtil.waitForMoment(driver, sortreturnPriceL2H);
		sortreturnPriceL2H.click();
		TestUtil.waitForMoment(driver, firstSortedReturnFlight);
		firstSortedReturnFlight.click();
	}
	
	public void ClickOnBookNowBTN() {
		TestUtil.waitForMoment(driver, bookNowBTN);
		bookNowBTN.click();
	}
	
	public void ClickOnContinueBTN() {
		TestUtil.waitForMoment(driver, continueBTN);
		continueBTN.click();
	}
	
	public void validateReviewPage() {
		
		TestUtil.switchToNewTab();
		
		System.out.println("Header of Review Page: " + reviewForBookingText.getText());
		Assert.assertEquals(reviewForBookingText.getText(), "Review your booking");
		
		TestUtil.scrollToView(charityCB);
		charityCB.click();
		continueBTNReview.click();
		
	}

}
