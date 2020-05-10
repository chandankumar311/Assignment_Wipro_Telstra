package com.Assignment1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DropDown2 {
	WebDriver driver;

	@Test
	public void test() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		List<WebElement> selwb = driver.findElements(
				By.xpath("//ul[contains(@class,'ui-menu ui-corner-bottom ui-widget ui-widget-content')]//li"));
		int i = 0;
		for (WebElement wb : selwb) {
			System.out.println(selwb.get(i));
			wb.click();
			WebElement ele2 = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", ele2);
			i++;
			Thread.sleep(3000);
		}
	}

	@AfterTest
	public void after() {
		//driver.quit();

	}

}