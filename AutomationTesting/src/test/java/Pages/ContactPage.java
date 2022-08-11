package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Testbase.baseClass;

public class ContactPage extends baseClass{

	public void validateErrors() {
		
	SoftAssert softAssert = new SoftAssert();
		
		String HEADER_ERR_MESSAGE = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
		
		String FORENAME_ERR_MESSAGE = "Forename is required";
		String EMAIL_ERR_MESSAGE = "Email is required";
		String MESSAGE_ERR_MESSAGE = "Message is required";
	
		softAssert.assertEquals(driver.findElement(By.xpath(OR.getProperty("err_msgHeader"))), HEADER_ERR_MESSAGE);

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		softAssert.assertEquals(driver.findElement(By.xpath(OR.getProperty("err_msgForename"))), FORENAME_ERR_MESSAGE);
		softAssert.assertEquals(driver.findElement(By.id(OR.getProperty("err_msgEmail"))), EMAIL_ERR_MESSAGE);
		softAssert.assertEquals(driver.findElement(By.id(OR.getProperty("err_Message"))), MESSAGE_ERR_MESSAGE);
		softAssert.assertAll();
		
		
		
		
	}

	public void enterFieldInfo(String forename, String email, String message) {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id(OR.getProperty("input_forename"))).sendKeys(forename);
		driver.findElement(By.id(OR.getProperty("input_email"))).sendKeys(email);
		driver.findElement(By.id(OR.getProperty("input_message"))).sendKeys(message);
	
	}

	public void clickOnSubmit() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(OR.getProperty("submitbtn"))).click();
	}

	public void validateNoErrors() {
		// TODO Auto-generated method stub
		
	}

	public void validsuceess() {
		
		// TODO Auto-generated method stub
		String message = driver.findElement(By.xpath(OR.getProperty("msg_success"))).getText();
		
		System.out.print(message);
		Assert.assertEquals(message, "Thanks Anu, we appreciate your feedback.");
		
		
	}

	public void clikonBack() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath(OR.getProperty("backbtn"))).click();
	}
	
	


}
