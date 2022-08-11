package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Testbase.BaseClass;

public class ContactPageTest extends BaseClass{
	
	
	ContactPage contactPage = new ContactPage();
	
	@Test(enabled = true, priority = 1)
	public void validateContactPage() {

		getDriver().findElement(By.xpath(OR.getProperty("contact"))).click();
		getDriver().findElement(By.xpath(OR.getProperty("submitbtn"))).click();
		
		//write code for validate errors STEP 3
//		contactPage.enterTextFieldInfoByID("input_forename", "Anu");
		getDriver().findElement(By.id(OR.getProperty("input_forename"))).sendKeys("Anu");
//	//	contactPage.validateErrors();
//		contactPage.enterFieldInfo("Anu", "saianuradha24@gmail.com", "India");
//		contactPage.clickOnSubmit();
//		contactPage.validsuceess();
//		contactPage.clikonBack();
//	//	contactPage.validateNoErrors();

}
}