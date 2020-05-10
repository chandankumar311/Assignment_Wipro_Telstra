package com.Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExcelDataConfig excelData;
	public static ExtentTest logger;
	public static ExtentReports extent;
	
	public TestBase() {
		try {
			prop = new Properties();
			File src = new File(System.getProperty("user.dir") + "/src/main/java/com/Assignment/Config/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enterURL(String url) {
		driver.get(prop.getProperty(url));
	}
	
	public static void initialization() {
		BrowserFactory.startBrowser(prop.getProperty("browser"));
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	}
	
	// For Olay Assignment only
	public void verifyURL(String currentUrl) {
		String partialURL_UK_Eng = excelData.getData(2, 1, 1);
		String partialURL_German = excelData.getData(2, 2, 1);
		String partialURL_Spanish = excelData.getData(2, 3, 1);

		if (currentUrl.contains(partialURL_UK_Eng)) {
			Reporter.log("User is on Registeration page of UK - English: " + currentUrl);
			System.out.println("User is on Registeration page of UK - English: " + currentUrl);
		} else if (currentUrl.contains(partialURL_German)) {
			Reporter.log("User is on Registeration page of German language: " + currentUrl);
			System.out.println("User is on Registeration page of German language: " + currentUrl);
		} else if (currentUrl.contains(partialURL_Spanish)) {
			Reporter.log("User is on Registeration page of Spanish language: " + currentUrl);
			System.out.println("User is on Registeration page of Spanish language: " + currentUrl);
		}

	}

}
