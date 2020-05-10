package com.Assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;
import com.Utility.TestUtil;

public class SelectMenuOption extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//span[@id='speed-button']/span[last()-1]")
	private WebElement speedDD;
	
	public WebElement speedDD_New = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
	
	@FindBy(xpath = "//span[@id='files-button']/span[last()-1]")
	private WebElement fileDD;
	
	@FindBy(xpath = "//span[@id='number-button']/span[last()-1]")
	private WebElement numberDD;
	
	@FindBy(xpath = "//span[@id='salutation-button']/span[last()-1]")
	private WebElement titleDD;
	
	String speedSelectXpath = "//ul[contains(@class,'ui-menu ui-corner-bottom ui-widget ui-widget-content')]//li";
	//String speedSelectXpath = "//div[contains(@class,'ui-selectmenu-open')]/descendant::li";
	public List<WebElement> speedSelect = driver.findElements(By.xpath(speedSelectXpath));
	
	String fileSelectXpath = "//ul[@id='files-menu']/descendant::li";
	public List<WebElement> fileSelect = driver.findElements(By.xpath(fileSelectXpath));
	
	String numberSelectXpath = "//ul[@id='number-menu']/descendant::li";
	public List<WebElement> numberSelect = driver.findElements(By.xpath(numberSelectXpath));
	
	String titleSelectXpath = "//ul[@id='salutation-menu']/descendant::li";
	public List<WebElement> titleSelect = driver.findElements(By.xpath(titleSelectXpath));
	
	public List<WebElement> speedLists = driver.findElements(
			By.xpath("//ul[contains(@class,'ui-menu ui-corner-bottom ui-widget ui-widget-content')]//li"));
	
	public WebElement element = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
	
	// Initializing the Page Objects:
	public SelectMenuOption() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	/*public void clickOptionOfSelectDD() {
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		List<String> optionTextList = new ArrayList<String>();
		for(WebElement option : options) {
			String text = option.getAttribute("innerHTML").trim();
			optionTextList.add(text);
		}
		System.out.println("Options are: " + optionTextList);
		
		for(String optionText : optionTextList) {
			System.out.println(optionText);
			sel.selectByVisibleText(optionText);
		}		
	}*/
	
	public void selectSpeedDDOneByOne() {
		//WebElement ele = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", speedDD_New);
		//List<WebElement> selwb = driver.findElements(By.xpath("//ul[contains(@class,'ui-menu ui-corner-bottom ui-widget ui-widget-content')]//li"));
		int i = 0;
		for (WebElement speed : speedLists) {
			speed.click();
			//WebElement ele2 = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", element);
			i++;
			TestUtil.waitFor2Sec();
		}	
			
	}
	
	public void clickSpeedDD() {
		speedDD.click();
		TestUtil.waitFor2Sec();
	}
	
	public void clickFileDD() {
		fileDD.click();
		TestUtil.waitFor2Sec();
	}
	
	public void clickNumberDD() {
		numberDD.click();
		TestUtil.waitFor2Sec();
	}
	
	public void clickTitleDD() {
		titleDD.click();
		TestUtil.waitFor2Sec();
	}
	
	public WebElement getSpeedDD() {
		return speedDD;
	}
	
	public WebElement getFileDD() {
		return fileDD;
	}
	
	public WebElement getNumberDD() {
		return numberDD;
	}
	
	public WebElement getTitleDD() {
		return titleDD;
	}

}
