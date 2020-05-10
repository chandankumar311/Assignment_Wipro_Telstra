package com.Assignment1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;

public class DatePickerDOB extends TestBase{

	// Page Factory - OR:
	@FindBy(css = "input#datepicker")
	private WebElement dateTextBox;
	
	@FindBy(css = "span.ui-datepicker-month")
	private WebElement monthCalander;
	
	@FindBy(css = "span.ui-datepicker-year")
	private WebElement yearCalander;
	
	@FindBy(xpath = "//span[text()='Prev']")
	private WebElement previousLink;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/descendant::a")
	public List<WebElement> tableDates;

	// Initializing the Page Objects:
	public DatePickerDOB(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void ClickOndateTextBox() {
		dateTextBox.click();
	}
	
	public void clickOnPrevious() {
		previousLink.click();
	}

	public WebElement getYear() {
		return yearCalander;
	}

	public WebElement getMonth() {
		return monthCalander;
	}

}
