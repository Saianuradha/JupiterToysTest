package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Testbase.baseClass;

public class LoginTest extends baseClass{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
		Thread.sleep(3000);
	}

}
