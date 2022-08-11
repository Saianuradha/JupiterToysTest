package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsActions {
	public WebDriver driver;
	
	public ElementsActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

}
