package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Testbase.BaseClass;

public class ContactPageTest extends BaseClass{
	private ContactPage contactPage;
	public WebDriver driver;
	
	@BeforeTest
	public void before() {
		this.driver = BaseClass.driver;
		contactPage = new ContactPage(driver);
		launchUrl();
	}
	
	
	@Test(description = "Test Case 1",enabled = true, priority = 1)
	public void validateContactPage() {

		driver.findElement(By.xpath("//*[@id=\"nav-contact\"]/a")).click();
		contactPage.submitClick();
		
		contactPage.validateErrors();
		contactPage.enterTextFieldInfoByID("forename", "Anu");
		contactPage.enterTextFieldInfoByID("email", "saianuradha24@gmail.com");
		contactPage.enterTextFieldInfoByID("message", "India");
		contactPage.validateErrorsAreGone();
		launchHomePage();

	}
	
	@Test(description = "Test Case 2", enabled = true, priority = 2, invocationCount = 5)
	public void validateContactPageValidSuccess() {

		driver.findElement(By.xpath("//*[@id=\"nav-contact\"]/a")).click();
		
		contactPage.enterTextFieldInfoByID("forename", "Anu");
		contactPage.enterTextFieldInfoByID("email", "saianuradha24@gmail.com");
		contactPage.enterTextFieldInfoByID("message", "India");
		
		contactPage.submitClick();
		contactPage.validsuccess();
		contactPage.clickonBack();
		launchHomePage();
	}
	
	@AfterMethod
	public void after() {
		launchHomePage();
	}
	
	
}