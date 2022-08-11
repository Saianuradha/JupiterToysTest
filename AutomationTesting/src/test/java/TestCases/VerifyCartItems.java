package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ShoppingPage;
import Testbase.BaseClass;

public class VerifyCartItems extends BaseClass{
	
	public ShoppingPage shop;
	public CartPage cart;
	
//	public VerifyCartItems() {
////	 shop = new ShoppingPage(driver);
////	 cart = new CartPage(driver);
//	}
	
	@BeforeTest
	public void before() {
		shop = new ShoppingPage(driver);
		cart = new CartPage(driver);
	}
	
	@Test(enabled = true, priority = 1)
	public void addItemsAndVerify() {
		
		driver.findElement(By.xpath(OR.getProperty("ShopLink"))).click();
		List<String> shoppingItems = new ArrayList<>();
		shoppingItems.add("Funny Cow");
		shoppingItems.add("Fluffy Bunny");
		
		String item0 = "//h4[text()='"+shoppingItems.get(0)+"']/..//a";
		String item1 = "//h4[text()='"+shoppingItems.get(1)+"']/..//a";

		shop.addItem(item0);
		shop.addItem(item1);
		shop.addItem(item0);
		cart.viewCart();
		
		String funnyCowText = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[1]")).getText(); 
		String funncyCowQuantityInCart = driver.findElement(By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[3]/input")).getAttribute("value");
		Assert.assertEquals(funncyCowQuantityInCart, "2","FunnyCow Quantity is matched");
		Assert.assertEquals(funnyCowText, "Funny Cow","Funny Cow Text is matched");
		
		//TODO add for fluffy bunny
	
	}

}
