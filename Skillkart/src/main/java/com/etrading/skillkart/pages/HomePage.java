package com.etrading.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.etrading.skillkart.generic.WebActionUtil;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//ul/li/a[text()='Women']")
	WebElement women;
	@FindBy(xpath="(//li/a[text()='Dresses'])[2]")
	WebElement dresses;
	@FindBy(xpath="(//li/a[text()='T-shirts'])[2]")
	WebElement tshirts;
	@FindBy(xpath="//a[@class=\"logout\"]")
	WebElement bt_logout;
	
public HomePage(WebDriver driver,WebActionUtil webactionutil) {
	super(driver,webactionutil);
}

public CategoryPage menuList(String menuchoice) {
	menuchoice=menuchoice.toLowerCase();
	switch(menuchoice)
	{
	case "dresses":webActionUtil.jsClick(dresses);
	break;
	case "tshirts":webActionUtil.jsClick(tshirts);
	break;
	case "women":webActionUtil.jsClick(women);
	break;
	}
	return new CategoryPage(driver,webActionUtil);
	
}
public void Logout() {
webActionUtil.click(bt_logout);
}

}
