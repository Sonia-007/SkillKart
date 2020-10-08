package com.etrading.skillkart.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.etrading.skillkart.pages.CategoryPage;
import com.etrading.skillkart.pages.HomePage;
import com.etrading.skillkart.pages.OrderDetailPage;
import com.etrading.skillkart.pages.ProductDetailPage;

public class TestCase001 extends BaseTest {

	@Test(description="Add item to cart, Verify whether product is displayed or not ")
	public void AddItemToKart() {
		
		HomePage hp = new HomePage(driver, webActionUtil);
		CategoryPage category = hp.menuList("Dresses");
		ProductDetailPage pdp = category.clickOnProduct("5");
		//pdp.increaseQuantity(4);
		//pdp.decreaseQuantity(1);
		pdp.selectSize("L");
		pdp.selectColor("Blue");
		pdp.clickOnAddToKart();
		OrderDetailPage odp = pdp.clickOnProccedToCheckout();
		Assert.assertEquals(odp.isDisplayed("5"), true);
		
	}

}
