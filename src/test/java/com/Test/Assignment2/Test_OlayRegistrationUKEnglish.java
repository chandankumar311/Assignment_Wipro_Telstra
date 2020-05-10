package com.Test.Assignment2;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment2.OlayRegistrationUKEnglish;
import com.Utility.ExcelDataConfig;
import com.Utility.TestBase;

@Listeners(com.Utility.TestListener.class)
public class Test_OlayRegistrationUKEnglish extends TestBase{
	
	OlayRegistrationUKEnglish olayRegistrationUKEnglish;
	ExcelDataConfig excelData;

	public Test_OlayRegistrationUKEnglish() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("OlayRegistrationUKEnglish");
		olayRegistrationUKEnglish = new OlayRegistrationUKEnglish();
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	}
	
	@Test(dataProvider = "Authentication", priority = 3, dependsOnMethods = {"vrifyOlayRegistrationUK_English_URL"}, description = "This test case will register new user for Olay UK - English.")
	public void signInOlayUK_English(String email, String password){
			if(driver.getTitle().contains("Login") && olayRegistrationUKEnglish.getSignINHeaderLoginPage().equals("SIGN IN")) {
				olayRegistrationUKEnglish.getSignInEmailTextBoxLoginPage().clear();
				olayRegistrationUKEnglish.getSignInEmailTextBoxLoginPage().sendKeys(email);
				olayRegistrationUKEnglish.getsignInPasswordTextBoxLoginPage().clear();
				olayRegistrationUKEnglish.getsignInPasswordTextBoxLoginPage().sendKeys(password);
				olayRegistrationUKEnglish.clickSignInButtonLoginPage();
			}
	}
	
	@DataProvider(name = "Authentication")
	public Object[][] credentials(){
		
		int rows = excelData.getRowCount(2);
		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = excelData.getData(2, i, 2);
			data[i][1] = excelData.getData(2, i, 3);
		}
		System.out.println("Email & Pwd: " + data.toString());
		return data;
	}
	

	@Test(priority = 1, description = "This test case will verify Registeration page of UK - English URL.")
	public void vrifyOlayRegistrationUK_English_URL() {
		verifyURL(driver.getCurrentUrl());
	}
	
	@Test(priority = 2, dependsOnMethods = {"vrifyOlayRegistrationUK_English_URL"}, description = "This test case will register new user for Olay UK - English.")
	public void registrationOlayUK_English() {
		olayRegistrationUKEnglish.clickRegisterLink();
		olayRegistrationUKEnglish.clickAcceptAllCookies();
		olayRegistrationUKEnglish.clickCloseImgSkinAdvisor();
		olayRegistrationUKEnglish.setEmailInTextBox();
		olayRegistrationUKEnglish.setPassword();
		olayRegistrationUKEnglish.setConfirmPassword();
		olayRegistrationUKEnglish.setDateOfBirth();
		olayRegistrationUKEnglish.clickOnRegisterAndCreateYourProfile();
		
		String errorMsgAlreadyExists = olayRegistrationUKEnglish.getErrorMsgAlreadyExists();
		if(errorMsgAlreadyExists.equals("An account with this email address already exists."))
			olayRegistrationUKEnglish.clickSignInLinkTop();
	}
	
	@Test(priority = 4, dependsOnMethods = {"signInOlayUK_English"}, description = "This test case will validate login error message for Olay UK - English.")
	public void validateErrorMsgLoginPage() {
		String expectedErrorMsgLoginPage = "The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
		String actualErrorMsgLoginPage = olayRegistrationUKEnglish.getErrorMsgWrongCredentialsLoginPage();
		Assert.assertEquals(actualErrorMsgLoginPage, expectedErrorMsgLoginPage); 
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
		Reporter.log("==========Browser Closed==========");
		System.out.println("==========Browser Closed==========");
	}

}
