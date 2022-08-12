package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ContactPage;
import Pages.ShoppingPage;
import Testbase.BaseClass;

public class ContactPageTest extends BaseClass{
	
	
	ContactPage contactPage;
	@BeforeTest
	public void before() {
		contactPage = new ContactPage(driver);
	}
	
	@Test(enabled = true, priority = 1)
	public void validateContactPage() {

		driver.findElement(By.xpath(OR.getProperty("contact"))).click();
		contactPage.submitClick();
		
		contactPage.validateErrors();
		contactPage.enterTextFieldInfoByID("input_forename", "Anu");
		contactPage.enterTextFieldInfoByID("input_email", "saianuradha24@gmail.com");
		contactPage.enterTextFieldInfoByID("input_message", "India");
		contactPage.validateErrorsAreGone();
		contactPage.submitClick();
		contactPage.validsuceess();

}
}