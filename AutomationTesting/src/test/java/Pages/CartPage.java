package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Testbase.BaseClass;
import Utilities.ElementsActions;

public class CartPage {
	public WebDriver driver;
	public ElementsActions elementActions;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementsActions(driver);
	}
	
	public String btn_cart="//*[@id=\"nav-cart\"]/a";
//	public String btnbuy_fluffyBunny="//*[@id=\"product-4\"]/div/p/a";
	
	public void viewCart() {
		elementActions.click(btn_cart);
	}

}
