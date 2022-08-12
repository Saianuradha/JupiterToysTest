package Pages;

import org.openqa.selenium.WebDriver;

import Utilities.ElementsActions;

public class ShoppingPage{
	public WebDriver driver;
	public ElementsActions elementActions;
	
	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementsActions(driver);
	}
	
	public String btnbuy_funnycow="//*[@id='product-6']/div/p/a";
	public String btnbuy_fluffyBunny="//*[@id=\"product-4\"]/div/p/a";
	
	public void addItem(String value) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementActions.click(value);
	}
	
	public void addItem2(String value) {
		try {
			//To avoid stale element 
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementActions.click(value);
	}
	
	

}
