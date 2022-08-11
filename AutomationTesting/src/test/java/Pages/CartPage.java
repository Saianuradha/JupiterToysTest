package Pages;

import org.openqa.selenium.By;

import Testbase.BaseClass;

public class CartPage extends BaseClass{
	
	public void navigateTocart() {
		
			getDriver().findElement(By.xpath(OR.getProperty("cart"))).click();
			
	}

}
