package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ShoppingPage;
import Testbase.BaseClass;

public class VerifyCartItemsTest extends BaseClass{
	
	public ShoppingPage shop;
	public CartPage cart;
	
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
		
		String item0Text = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[1]")).getText(); 
		String item0QuantityInCart = driver.findElement(By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[3]/input")).getAttribute("value");
		Assert.assertEquals(item0QuantityInCart, "2","FunnyCow Quantity is matched");
		Assert.assertEquals(item0Text, shoppingItems.get(0),"Funny Cow Text is matched");
		
		
		String item1Text = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[2]/td[1]")).getText(); 
		String item1QuantityInCart = driver.findElement(By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[2]/td[3]/input")).getAttribute("value");
		Assert.assertEquals(item1QuantityInCart, "1","Fluffy Bunny Quantity is matched");
		Assert.assertEquals(item1Text, shoppingItems.get(1),"Fluffy Bunny Text is matched");
		
	
	}

}
