package com.Test.Assignment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.SelectMenuOption;
import com.Utility.ExcelDataConfig;
import com.Utility.TestBase;
import com.Utility.TestUtil;

@Listeners(com.Utility.TestListener.class)
public class Test_SelectMenuOption extends TestBase{
	
	SelectMenuOption selectMenuOption;
	ExcelDataConfig excelData;

	public Test_SelectMenuOption() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("SelectMenuOption");
		selectMenuOption = new SelectMenuOption();
		excelData = new ExcelDataConfig("./src/main/java/com/Assignment/TestData/Chandan_Assesment.xlsx");
	}

	@Test(priority = 1, description = "This test case will select the speed one by one.")
	public void selectSpeed() throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Selectmenu"), "User is not on Selectmenu page.");
		//selectMenuOption.selectSpeedDDOneByOne();
		
		/*driver.findElement(By.xpath("//span[@id='speed-button']/span[last()]")).click();
		System.out.println(selectMenuOption.speedSelect.getClass().getName());
		System.out.println(selectMenuOption.speedSelect);
		for(WebElement speed : selectMenuOption.speedSelect) {
			//WebElement speed = selectMenuOption.speedSelect.get(i);
			String text = speed.getAttribute("innerHTML");
			System.out.println(text);
			speed.click();
		}*/
		
		//driver.findElement(By.xpath("//span[@id='speed-button']/span[last()-1]")).click();
		
		/*try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}*/
		
		selectMenuOption.clickSpeedDD();
		for(int i=0; i<2; i++) {
			new Actions(driver).pause(1000).sendKeys(Keys.DOWN, Keys.ENTER).perform();
			if(i==1) {
				break;
			}
			selectMenuOption.clickSpeedDD();
		}
		
	}
	
	@Test(priority = 2, description = "This test case will select the file one by one.")
	public void selectFile() {
		TestUtil.scrollToView(selectMenuOption.getFileDD());
		selectMenuOption.clickFileDD();
		for(int i=0; i<3; i++) {
			new Actions(driver).pause(1000).sendKeys(Keys.DOWN, Keys.ENTER).perform();
			if(i==2) {
				break;
			}
			selectMenuOption.clickFileDD();
		}
	}
	
	@Test(priority = 3, description = "This test case will select the number one by one.")
	public void selectNumber() {
		TestUtil.scrollToView(selectMenuOption.getNumberDD());
		selectMenuOption.clickNumberDD();
		for(int i=0; i<18; i++) {
			new Actions(driver).pause(1000).sendKeys(Keys.DOWN, Keys.ENTER).perform();
			if(i==17) {
				break;
			}
			selectMenuOption.clickNumberDD();
		}
	}
	
	@Test(priority = 4, description = "This test case will select the title one by one.")
	public void selectTitle() {
		TestUtil.scrollToView(selectMenuOption.getTitleDD());
		selectMenuOption.clickTitleDD();
		for(int i=0; i<5; i++) {
			new Actions(driver).pause(1000).sendKeys(Keys.DOWN, Keys.ENTER).perform();
			if(i==4) {
				break;
			}
			selectMenuOption.clickTitleDD();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("==========Browser Closed==========");
	}

}
