package com.Assignment1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;

public class SelectableItem_ClickItem_GetItemName extends TestBase{
	
	//Page Factory - OR:
	@FindBy(linkText = "Selectable")
	private WebElement selectablelink;
	
	@FindBy(xpath = "//ol[@id='selectable']/li")
	public List<WebElement> items;
	
	//Initializing the Page Objects:
	public SelectableItem_ClickItem_GetItemName(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public void clickOnselectablelink(){
		selectablelink.click();;
	}

}
