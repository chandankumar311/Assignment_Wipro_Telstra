
package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @author CHANDAN KUMAR
 */

public class TestListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS){
			Calendar calender = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
			
			String methodName = result.getName();
			TakesScreenshot tss = (TakesScreenshot)driver;
			File srcFile = tss.getScreenshotAs(OutputType.FILE);
			
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/Screenshots";

				File destFile = new File(reportDirectory + "/Test_Success/" + methodName + "_" + formater.format(calender.getTime()) + ".png");

				FileHandler.copy(srcFile, destFile);
				
				Reporter.log("<a href = '" + destFile.getAbsolutePath()+ "'> <img src = '" + destFile.getAbsolutePath()+ "' height = '100' width = '100'/> </a>");
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
		
	}

	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE){
			Calendar calender = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
			
			String methodName = result.getName();
			TakesScreenshot tss = (TakesScreenshot)driver;
			File srcFile = tss.getScreenshotAs(OutputType.FILE);
			
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\Screenshots";
				
				File destFile = new File(reportDirectory + "/Test_Failure/" + methodName + "_" + formater.format(calender.getTime()) + ".png");
				
				FileHandler.copy(srcFile, destFile);
				
				Reporter.log("<a href = '" + destFile.getAbsolutePath()+ "'> <img src = '" + destFile.getAbsolutePath()+ "' height = '100' width = '100'/> </a>");
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
