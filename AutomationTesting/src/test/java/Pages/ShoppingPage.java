package Pages;

import org.openqa.selenium.By;

import Testbase.BaseClass;

public class ShoppingPage extends BaseClass{
	
	public void itemClick(String key) {
		getDriver().findElement(By.xpath(OR.getProperty(key))).click();
	}

}
