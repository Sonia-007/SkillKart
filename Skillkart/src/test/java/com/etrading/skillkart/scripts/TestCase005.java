package com.etrading.skillkart.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.etrading.skillkart.generic.ExcelLibaray;
import com.etrading.skillkart.generic.Utilities;
import com.etrading.skillkart.pages.CategoryPage;
import com.etrading.skillkart.pages.HomePage;
import com.etrading.skillkart.pages.OrderDetailPage;
import com.etrading.skillkart.pages.ProductDetailPage;

public class TestCase005 extends BaseTest{
	@Test(description="Using Data Driven Verify Whether the Added Product From Quick View is displayed in ODP")
	public void textmethod() {
		HomePage hp=new HomePage(driver,webActionUtil);
		String menuchoice=ExcelLibaray.requiredData(XL_PATH,"TC003", 1,0);
		CategoryPage cp = hp.menuList(menuchoice);
		String productId = Utilities.getIntText(ExcelLibaray.requiredData(XL_PATH,"TC003", 1,1));
		ProductDetailPage pdp = cp.quickVeiwProduct(Utilities.getIntText(ExcelLibaray.requiredData(XL_PATH,"TC003", 1,1)));
		int quantity=Utilities.returnInteger(ExcelLibaray.requiredData(XL_PATH,"TC003", 1,2));
		String size=ExcelLibaray.requiredData(XL_PATH,"TC003", 1,3);
		String color=ExcelLibaray.requiredData(XL_PATH,"TC003", 1,4);
		pdp.addItemToKart(quantity, size, color);
		OrderDetailPage odp = pdp.clickOnProccedToCheckout();
		assertEquals(odp.isDisplayed(productId), true,"not displayed");
	}

}