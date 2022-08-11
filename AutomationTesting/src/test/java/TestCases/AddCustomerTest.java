package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Testbase.baseClass;

public class AddCustomerTest extends baseClass{
	
	@Test
	public void addcustomer() {
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();
	}

}
