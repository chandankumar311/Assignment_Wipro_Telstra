package com.Test.Assignment1;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Assignment1.DragAndDropTarget;
import com.Utility.TestBase;


@Listeners(com.Utility.TestListener.class)
public class Test_DragAndDropTarget extends TestBase{
	
	DragAndDropTarget dragAndDropTarget;

	public Test_DragAndDropTarget() {

	}

	@BeforeTest
	public void setUp() {
		initialization();
		enterURL("DragAndDropTargetURL");
		dragAndDropTarget = new DragAndDropTarget();
	}

	@Test(priority = 1, description = "This test case will verify the text before dragging.")
	public void verifyText() {
		
		dragAndDropTarget.getDroppableLink().click();
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Droppable"), "User is not on Droppable page.");
		
		// Getting text before performing drag and drop action
		dragAndDropTarget.getDraggableText();
		Assert.assertEquals(dragAndDropTarget.getDraggableText(), "Drag me to my target");
		
		dragAndDropTarget.getDroppableTargetText();
		Assert.assertEquals(dragAndDropTarget.getDroppableTargetText(), "Drop here");
	}

	@Test(priority = 2, dependsOnMethods = {"verifyText"}, description = "This test case will open the Google link in new TAB")
	public void dragAndDropAction() {
		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragAndDropTarget.getDraggableItem(), dragAndDropTarget.getDroppableTarget()).perform();;
		
		Assert.assertEquals(dragAndDropTarget.getDroppableTargetText(), "Dropped!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("==========Browser Closed==========");
	}

}
