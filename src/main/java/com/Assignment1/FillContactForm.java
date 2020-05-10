package com.Assignment1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;

public class FillContactForm extends TestBase{
	
	// Page Factory - OR:
	@FindBy(xpath = "//label[text()='First Name']/following-sibling::input[@class='firstname']")
	private WebElement firstNameTextBox;
	
	@FindBy(css = "input#lname")
	private WebElement lastNameTextBox;

	@FindBy(css = "input[name='country']")
	private WebElement countryTextBox;
	
	@FindBy(partialLinkText = "Google Link")
	public List<WebElement> googleLinks;
	
	@FindBy(css = "textarea#subject")
	private WebElement subjectTextBox;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitBtn;
	
	

	// Initializing the Page Objects:
	public FillContactForm(){
			PageFactory.initElements(driver, this);
		}

	// Actions
	public void setFirstName(String firstName) {
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastNameTextBox.sendKeys(lastName);
	}
	
	public void setCountryName(String countryName) {
		countryTextBox.sendKeys(countryName);
	}
	
	public void setSubject(String subjectName) {
		subjectTextBox.sendKeys(subjectName);
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}

}
