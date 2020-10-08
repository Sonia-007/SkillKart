package com.etrading.skillkart.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_webAction {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	WebDriverWait wait;
public Practice_webAction(WebDriver driver) {
	this.driver=driver;
	actions=new Actions(driver);
	js=(JavascriptExecutor)driver;
	
}
public void sendKeys(WebElement target,String valueToEnter) {
	target.clear();
	target.sendKeys(valueToEnter);
}
public void click_action(WebElement target) {
	wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(target)).click();
	
}
public void click_js(WebElement target) {
js.executeScript("arguments[0].click();", target);
}

public void moveTowardElement(WebElement target) {
	actions.moveToElement(target).perform();
	
}
public void moveByoffset(int xoffset,int yoffset ) {
	actions.moveByOffset(xoffset, yoffset);
	
}
public void dragAnddrop(WebElement source ,WebElement target) {
	actions.dragAndDrop(source, target).perform();
	
}

public void selectbyValueOrIndex(WebElement listbox,String indexTextValue) {
	Select s=new Select(listbox);
	try {
		int index=Integer.parseInt(indexTextValue);
		s.selectByIndex(index);
	}
	catch(Exception e) {
		s.selectByValue(indexTextValue);
	}
	
}
}
