package com.etrading.skillkart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.etrading.skillkart.generic.WebActionUtil;

public class BasePage {
	WebDriver driver;
	WebActionUtil webActionUtil;
	public BasePage(WebDriver driver,WebActionUtil webActionUtil) {
		this.driver=driver;
		this.webActionUtil =webActionUtil;
		PageFactory.initElements(driver, this);
		
	}

}
