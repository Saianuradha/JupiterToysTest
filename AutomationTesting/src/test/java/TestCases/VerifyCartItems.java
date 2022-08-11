package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ShoppingPage;
import Testbase.BaseClass;

public class VerifyCartItems extends BaseClass{
	
	ShoppingPage shop = new ShoppingPage();
	CartPage cart = new CartPage();
	
	@Test(enabled = true, priority = 1)
	public void addItemsAndVerify() {
		
		getDriver().findElement(By.xpath(OR.getProperty("ShopLink"))).click();
		
		shop.itemClick("btnbuy_funnycow");
		shop.itemClick("btnbuy_funnycow");
		shop.itemClick("btnbuy_fluffybunny");
		cart.navigateTocart();	
	
	}

}
