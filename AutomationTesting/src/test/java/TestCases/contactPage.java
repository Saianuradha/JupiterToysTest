package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Testbase.baseClass;

public class contactPage extends baseClass{

	@Test(enabled = false, priority = 0)
	public void valiadteContactPage() throws InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("contact"))).click();
		driver.findElement(By.xpath(OR.getProperty("submitbtn"))).click();
		
		
	}
	
	@Test
	public void enterContactInfo(String forename, String email, String message) {
		WebDriverHelper.waitForElement(_submit);
		_inputForename.sendKeys(forename);
		_inputEmail.sendKeys(email);
		_inputMessage.sendKeys(message);
	}

	public void validateSuccessMessage(String forename) {
		WebDriverHelper.waitForElement(_success);
		String message = _msgSuccess.getText();		
		String thanks = message.substring(0,7);
		String feedback = message.substring(message.indexOf(","),message.length());
		Assert.assertEquals(message, thanks+forename+feedback);
	}
	
	
	
	@Test(enabled = false, priority = 1)
	
	public void validationErrors() {
		
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

	
	
}
