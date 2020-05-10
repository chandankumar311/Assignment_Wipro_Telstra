package com.Assignment1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.TestBase;

public class DragAndDropTarget extends TestBase{

	// Page Factory - OR:
	@FindBy(linkText = "Droppable")
	private WebElement droppableLink;

	@FindBy(css = "div#draggable")
	private WebElement draggableItem;
	
	@FindBy(css = "div#draggable p")
	private WebElement draggableItemText;
	
	@FindBy(css = "div#droppable")
	private WebElement droppableTarget;
	
	@FindBy(css = "div#droppable p")
	private WebElement droppableTargetText;

	// Initializing the Page Objects:
	public DragAndDropTarget(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public WebElement getDroppableLink() {
		return droppableLink;
	}

	public String getDraggableText() {
		return draggableItemText.getText();
	}

	public String getDroppableTargetText() {
		return droppableTargetText.getText();
	}
	
	public WebElement getDraggableItem() {
		return draggableItem;
	}
	
	public WebElement getDroppableTarget() {
		return droppableTarget;
	}

}
