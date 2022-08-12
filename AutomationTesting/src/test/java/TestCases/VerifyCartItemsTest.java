package TestCases;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	@Test(enabled = false, priority = 1)
	public void addItemsAndVerify() {
		
		driver.findElement(By.xpath(OR.getProperty("ShopLink"))).click();
//		HashMap<String,Integer> testData = new HashMap<>();
//		testData.put("Fluffy Bunny", 1);
//		testData.put("Funny Cow", 2);
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
	
	@Test(enabled = true, priority = 1)
	public void addItemsAndVerifyCartPrice() {
		
		driver.findElement(By.xpath(OR.getProperty("ShopLink"))).click();
		List<String> shoppingItems = new ArrayList<>();
		shoppingItems.add("Stuffed Frog");
		shoppingItems.add("Fluffy Bunny");
		shoppingItems.add("Valentine Bear");
		
		String item0 = "//h4[text()='"+shoppingItems.get(0)+"']/..//a";
		String item1 = "//h4[text()='"+shoppingItems.get(1)+"']/..//a";
		String item2 = "//h4[text()='"+shoppingItems.get(2)+"']/..//a";

		shop.addItem(item0);
		shop.addItem(item0);
		shop.addItem(item1);
		shop.addItem(item1);
		shop.addItem(item1);
		shop.addItem(item1);
		shop.addItem(item1);
		shop.addItem(item2);
		shop.addItem(item2);
		shop.addItem(item2);
		
		cart.viewCart();
		
		String item0Price = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[2]")).getText(); 
		String item0Quantity = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[3]/input")).getAttribute("value");
		String item0SubTotal = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[1]/td[4]")).getText(); 
		
		String item1Price = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[2]/td[2]")).getText(); 
		String item1Quantity = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[2]/td[3]/input")).getAttribute("value");
		String item1SubTotal = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[2]/td[4]")).getText(); 
		String item2Price = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[3]/td[2]")).getText(); 
		String item2Quantity = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[3]/td[3]/input")).getAttribute("value"); 
		String item2SubTotal = driver.findElement(
				By.xpath("//table[@class='table table-striped cart-items']//tbody/tr[3]/td[4]")).getText(); 
		
		String total = driver.findElement(
				By.xpath("//strong[@class=\'total ng-binding\']")).getText();
		
		Assert.assertEquals("$10.99", item0Price);
		Assert.assertEquals("$9.99", item1Price);
		Assert.assertEquals("$14.99", item2Price);
		
		Assert.assertEquals(calcSubTotal(item0Price, item0Quantity), item0SubTotal);
		Assert.assertEquals(calcSubTotal(item1Price, item1Quantity), item1SubTotal);
		Assert.assertEquals(calcSubTotal(item2Price, item2Quantity), item2SubTotal);
		
		
		Assert.assertEquals(calcTotal(item0SubTotal, item1SubTotal, item2SubTotal), total);
	
	}
	
	public String calcSubTotal(String price, String quantity) {
	
		return "$"+(Double.parseDouble(price.substring(1))*Integer.parseInt(quantity));
	}
	
	public String calcTotal(String subTotal1, String subTotal2, String subTotal3) {
		
		return "Total: "+(
				Double.parseDouble(subTotal1.substring(1))+
				Double.parseDouble(subTotal2.substring(1))+
				Double.parseDouble(subTotal3.substring(1))
				);
	}

}
