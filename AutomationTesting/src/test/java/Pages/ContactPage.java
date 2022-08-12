package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Testbase.BaseClass;
import Utilities.ElementsActions;

public class ContactPage extends BaseClass{
	public WebDriver driver;
	public ElementsActions elementActions;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementsActions(driver);
	}
public String submitBtn = "//*[text()='Submit']";

	public void submitClick() {
		driver.findElement(By.xpath(submitBtn)).click();
	}
	

	public void validateErrors() {
			
		String HEADER_ERR_MESSAGE = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
		
		String FORENAME_ERR_MESSAGE = "Forename is required";
		String EMAIL_ERR_MESSAGE = "Email is required";
		String MESSAGE_ERR_MESSAGE = "Message is required";
		
		String err_msgHeader = "//*[@id='header-message']";
		String err_msgForeName = "//*[@id='forename-err']";
		String err_msgEmail = "//*[@id='email-err']";
		String err_msgMessage = "//*[@id='message-err']";
		
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgForeName)).isDisplayed(),"err_msgForeName is Displayed");
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgEmail)).isDisplayed(),"err_msgEmail is Displayed");
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgMessage)).isDisplayed(),"err_msgMessage is Displayed");
	
		Assert.assertEquals(driver.findElement(By.xpath(err_msgHeader)).getText(), HEADER_ERR_MESSAGE);
		Assert.assertEquals(driver.findElement(By.xpath(err_msgForeName)).getText(), FORENAME_ERR_MESSAGE);
		Assert.assertEquals(driver.findElement(By.xpath(err_msgEmail)).getText(), EMAIL_ERR_MESSAGE);
		Assert.assertEquals(driver.findElement(By.xpath(err_msgMessage)).getText(), MESSAGE_ERR_MESSAGE);
	}
	
	public void validateErrorsAreGone() {
		
		String err_msgHeader = "//*[@id='header-message']";
		String HEADER_NO_ERR_MESSAGE = "We welcome your feedback - tell it how it is.";
		
		Assert.assertEquals(driver.findElement(By.xpath(err_msgHeader)).getText(), HEADER_NO_ERR_MESSAGE);
	
	}

	public void enterFieldInfo(String forename, String email, String message) {
		
		driver.findElement(By.id(OR.getProperty("input_forename"))).sendKeys(forename);
		driver.findElement(By.id(OR.getProperty("input_email"))).sendKeys(email);
		driver.findElement(By.id(OR.getProperty("input_message"))).sendKeys(message);
	
	}

	public void enterTextFieldInfoByID(String key, String value) {
		
		driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
	
	}

	
	public void clickOnSubmit() {
		driver.findElement(By.xpath(OR.getProperty("submitbtn"))).click();
	}


	public void validsuceess() {
		
		String message = driver.findElement(By.xpath(OR.getProperty("msg_success"))).getText();
		
		System.out.print(message);
		Assert.assertEquals(message, "Thanks Anu, we appreciate your feedback.");
		
		
	}

	public void clikonBack() {
		driver.findElement(By.xpath(OR.getProperty("backbtn"))).click();
	}
	
	


}
