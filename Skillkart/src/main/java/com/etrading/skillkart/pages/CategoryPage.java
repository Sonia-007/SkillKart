package com.etrading.skillkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.etrading.skillkart.generic.WebActionUtil;

public class CategoryPage extends BasePage{
	String quickView_xpath="//ul/li//a[@class=\"quick-view\" and contains(@href,'id_product=pid')]";
	@FindBy(xpath="//ul/li//a[@class=\"product_img_link\"]")
	List<WebElement>productlist;
	@FindBy(xpath="//ul/li//a[@class=\"quick-view\"]")
	List<WebElement>quickviewlist;
	
public CategoryPage(WebDriver driver,WebActionUtil webactionutil) {
	
	super(driver,webactionutil);
	
}

public ProductDetailPage clickOnProduct(String productId)
{
	String idproduct="id_product="+productId;
	for(WebElement product:productlist) {
		if(product.getAttribute("href").contains(idproduct)) {
		webActionUtil.jsClick(product);
		return new ProductDetailPage(driver,webActionUtil);
		}
	}
		return null;
	}
public ProductDetailPage quickVeiwProduct(String productId)
{
	
quickView_xpath=quickView_xpath.replace("pid",productId);
String quickView_parentxpath = quickView_xpath+"/../..";
String idproduct="id_product="+productId;
for(WebElement product:productlist) {
	if(product.getAttribute("href").contains(idproduct)) {
	webActionUtil.moveToElement(driver.findElement(By.xpath(quickView_parentxpath)));
	webActionUtil.click(driver.findElement(By.xpath(quickView_xpath)));
	driver.switchTo().frame(0);
	return new ProductDetailPage(driver,webActionUtil);
	}
}
	return null;
}


}
