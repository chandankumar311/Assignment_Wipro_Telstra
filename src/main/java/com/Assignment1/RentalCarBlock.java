package com.Assignment1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;

public class RentalCarBlock extends TestBase{

	// Page Factory - OR:
	@FindBy(css = "select#car-type")
	private WebElement rentalCarTypeTop;
	
	@FindBy(xpath = "//label[@for='transmission-standard']/span[last()-1]")
	private WebElement statndardRBTop;
	
	@FindBy(xpath = "//label[@for='transmission-automatic']/span[last() - 1]")
	private WebElement automaticRBTop;
	
	@FindBy(xpath = "//label[@for='insurance']/span[last()-1]")
	private WebElement insuranceCBTop;
	
	@FindBy(xpath = "//input[@id='horizontal-spinner']/parent::span/a[1]/span[last()-1]")
	private WebElement upSpinnerTop;
	
	@FindBy(xpath = "//input[@id='horizontal-spinner']/parent::span/a[2]/span[last()-1]")
	private WebElement downSpinnerTop;
	
	@FindBy(xpath = "//label[@for='insurance']/span[last()-1]")
	private WebElement bookNowBtnTop;	

	// Initializing the Page Objects:
	public RentalCarBlock(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public WebElement getRentalCarTypeTop() {
		return rentalCarTypeTop;
	}
	
	public WebElement getStatndardRBTop() {
		return statndardRBTop;
	}
	
	public WebElement getAutomaticRBTop() {
		return automaticRBTop;
	}
	
	public WebElement getInsuranceCBTop() {
		return insuranceCBTop;
	}
	
	public WebElement getUpSpinnerTop() {
		return upSpinnerTop;
	}
	
	public WebElement getDownSpinnerTop() {
		return downSpinnerTop;
	}
	
	public WebElement getBookNowBtnTop() {
		return bookNowBtnTop;
	}

	

}
