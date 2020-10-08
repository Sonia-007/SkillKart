package com.etrading.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.etrading.skillkart.generic.WebActionUtil;

public class OrderDetailPage extends BasePage {
	
	String cart_xpath="//tbody/tr/td[@class='cart_product']/a[contains(@href,'id_product=pid')]";
	@FindBy(xpath="//tbody/tr/td[@class='cart_product']/a")
	List<WebElement>productOnKart;
	
	

	public OrderDetailPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isDisplayed(String product_id) {
		product_id="id_product="+product_id;
		String product_xpath=cart_xpath.replace("id_product=pid", product_id);
		for(WebElement product:productOnKart) {
			if(product.getAttribute("href").contains(product_id)) {
				return true;
			}
		}
		return false;
	}
	/*public boolean isNotDisplayed(String product_id) {
		product_id="id_product="+product_id;
		String product_xpath=cart_xpath.replace("id_product=pid", product_id);
		try {
			webActionUtil.wait
		}
		return false;
	}*/

}
