package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Testbase.baseClass;

public class ContactPageTest extends baseClass{
	
	
	ContactPage contactPage = new ContactPage();
	
	@Test(enabled = true, priority = 1)
	public void validateContactPage() {
		driver.findElement(By.xpath(OR.getProperty("contact"))).click();
	//	driver.findElement(By.xpath(OR.getProperty("submitbtn"))).click();
	//	contactPage.validateErrors();
		contactPage.enterFieldInfo("Anu", "saianuradha24@gmail.com", "India");
		contactPage.clickOnSubmit();
		contactPage.validsuceess();
		contactPage.clikonBack();
	//	contactPage.validateNoErrors();

}
}