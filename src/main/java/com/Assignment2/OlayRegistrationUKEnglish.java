package com.Assignment2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Utility.TestBase;
import com.Utility.TestUtil;

public class OlayRegistrationUKEnglish extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signoutLinkTop;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutLinkPopUp;
	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signInLinkTop;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLinkCreatProfilePageBottom;
	
	@FindBy(xpath = "//input[contains(@id,'emails')]")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@data-key='newPassword']")
	private WebElement newPassword;
	
	@FindBy(xpath = "//input[contains(@id,'confirm')]")
	private WebElement confirmNewPassword;
	
	@FindBy(xpath = "//select[contains(@id,'birthdate][day')]")
	private WebElement birthDateDay;
	
	@FindBy(xpath = "//select[contains(@id,'birthdate][month')]")
	private WebElement birthDateMonth;
	
	@FindBy(xpath = "//select[contains(@id,'birthdate][year')]")
	private WebElement birthDateYear;
	
	@FindBy(xpath = "//input[@value='REGISTER AND CREATE YOUR PROFILE']")
	private WebElement registerAndCreateYourProfile;
	
	@FindBy(xpath = "//a[contains(@href,'en-us')]")
	private WebElement englishUSA;
	
	@FindBy(xpath = "//img[@alt='Close']")
	private WebElement closeImgSkinAdvisor;
	
	@FindBy(xpath = "//button[text()='Accept All Cookies']")
	private WebElement acceptAllCookies;
	
	@FindBy(xpath = "//button[text()='Reject All Cookies']")
	private WebElement rejectAllCookies;
	
	@FindBy(xpath = "//span[text()='An account with this email address already exists.']")
	private WebElement errorMsgAlreadyExists;
	
	@FindBy(xpath = "//h1")
	private WebElement signINHeaderLoginPage;
	
	@FindBy(xpath = "//input[@data-key='signInEmailAddress']")
	private WebElement signInEmailTextBoxLoginPage;
	
	@FindBy(xpath = "//input[@data-key='currentPassword']")
	private WebElement signInPasswordTextBoxLoginPage;
	
	@FindBy(xpath = "//input[@value='SIGN IN']")
	private WebElement signInButtonLoginPage;
	
	@FindBy(xpath = "(//span[contains(@class,'error-message')])[1]")
	private WebElement errorMsgWrongCredentialsLoginPage;
	
	
	
	
	


	// Initializing the Page Objects:
	public OlayRegistrationUKEnglish(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickRegisterLink() {
		registerLink.click();
	}
	
	public void setEmailInTextBox() {
		String email = excelData.getData(2, 1, 2);
		//String email = TestUtil.createUniqueFirstname() + "@gmail.com";
		emailTextBox.click();
		emailTextBox.sendKeys(email);
	}
	
	public void setPassword() {
		String password = excelData.getData(2, 1, 3);
		newPassword.sendKeys(password);
	}
	
	public void setConfirmPassword() {
		String confirmPassword = excelData.getData(2, 1, 4);
		confirmNewPassword.sendKeys(confirmPassword);
	}
	
	public void setDateOfBirth() {
		String birthDay_Day = excelData.getData(2, 1, 5);
		String birthDay_Month = excelData.getData(2, 1, 6);
		String birthDay_Year = excelData.getData(2, 1, 7);
		
		Select selDay = new Select(birthDateDay);
		selDay.selectByVisibleText(birthDay_Day);
		
		Select selMonth = new Select(birthDateMonth);
		selMonth.selectByVisibleText(birthDay_Month);
		
		Select selYear = new Select(birthDateYear);
		selYear.selectByVisibleText(birthDay_Year);
		
	}
	
	public void clickOnRegisterAndCreateYourProfile() {
		registerAndCreateYourProfile.click();
	}
	
	public void clickCloseImgSkinAdvisor() {
		new Actions(driver).pause(1000).moveToElement(closeImgSkinAdvisor).click().perform();
		//closeImgSkinAdvisor.click();
	}
	
	public void clickAcceptAllCookies() {
		new Actions(driver).pause(1000).moveToElement(acceptAllCookies).click().perform();
		//acceptAllCookies.click();
	}
	
	public void clickRejectAllCookies() {
		new Actions(driver).pause(1000).moveToElement(rejectAllCookies).click().perform();
		//rejectAllCookies.click();
	}
	
	public void clickSignInLinkTop() {
		signInLinkTop.click();
	}
	
	public String getErrorMsgAlreadyExists() {
		return errorMsgAlreadyExists.getText();
	}
	
	public String getSignINHeaderLoginPage() {
		return signINHeaderLoginPage.getText();
	}
	
	public WebElement getSignInEmailTextBoxLoginPage() {
		return signInEmailTextBoxLoginPage;
	}
	
	public WebElement getsignInPasswordTextBoxLoginPage() {
		return signInPasswordTextBoxLoginPage;
	}
	
	public void clickSignInButtonLoginPage() {
		signInButtonLoginPage.click();
	}
	
	public String getErrorMsgWrongCredentialsLoginPage() {
		return errorMsgWrongCredentialsLoginPage.getText();
	}
	

	

}
