package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Testbase.BaseClass;

public class ContactPageTest extends BaseClass{
	private ContactPage contactPage;
	
	@BeforeTest
	public void before() {
		goToHomePage();
		contactPage = new ContactPage(driver);
	}
	
	
	@Test(enabled = true, priority = 1)
	public void validateContactPage() {

		driver.findElement(By.xpath("//*[@id=\"nav-contact\"]/a")).click();
		contactPage.submitClick();
		
		contactPage.validateErrors();
		contactPage.enterTextFieldInfoByID("forename", "Anu");
		contactPage.enterTextFieldInfoByID("email", "saianuradha24@gmail.com");
		contactPage.enterTextFieldInfoByID("message", "India");
		contactPage.validateErrorsAreGone();
		goToHomePage();

	}
	
	@Test(enabled = true, priority = 2, invocationCount = 5)
	public void validateContactPageValidSuccess() {

		driver.findElement(By.xpath("//*[@id=\"nav-contact\"]/a")).click();
		
		contactPage.enterTextFieldInfoByID("forename", "Anu");
		contactPage.enterTextFieldInfoByID("email", "saianuradha24@gmail.com");
		contactPage.enterTextFieldInfoByID("message", "India");
		
		contactPage.submitClick();
		contactPage.validsuccess();
		contactPage.clickonBack();

	}
	
	
}