package com.etrading.skillkart.scripts;

import org.testng.annotations.Test;

import com.etrading.skillkart.generic.ExcelLibaray;
import com.etrading.skillkart.generic.Utilities;
import com.etrading.skillkart.pages.CategoryPage;
import com.etrading.skillkart.pages.HomePage;
import com.etrading.skillkart.pages.OrderDetailPage;
import com.etrading.skillkart.pages.ProductDetailPage;

public class TestCase002 extends BaseTest2 {
	@Test(description="input from xlsheet")
	public void testmethod() {
		
		
		HomePage hp = new com.etrading.skillkart.pages.HomePage(driver, webActionUtil);
		String sheetName = "TC003";
		
		String menuItem = ExcelLibaray.requiredData(XL_PATH, sheetName, 1, 0);
		String productID = Utilities.getIntText(ExcelLibaray.requiredData(XL_PATH, sheetName, 1, 1));
		//String productID="3";
		//int quantity=Utilities.returnInteger(ExcelLibaray.requiredData(XL_PATH, sheetName, 1, 2));
		
		String size=ExcelLibaray.requiredData(XL_PATH, sheetName, 1, 3);
		String color=ExcelLibaray.requiredData(XL_PATH, sheetName, 1, 4);
		
		CategoryPage category = hp.menuList(menuItem);
		ProductDetailPage pdp = category.quickVeiwProduct(productID);
		//pdp.increaseQuantity(quantity);
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		OrderDetailPage odp = pdp.clickOnProccedToCheckout();
		
	}
}
