package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
private String foreName = "forename";
private String email = "email";
private String message = "message";

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
		
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgForeName)).isDisplayed(),"err_msgForeName is not Displayed");
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgEmail)).isDisplayed(),"err_msgEmail is not Displayed");
		Assert.assertEquals(true, driver.findElement(By.xpath(err_msgMessage)).isDisplayed(),"err_msgMessage is not Displayed");
	
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

	public void enterTextFieldInfoByID(String key, String value) {
		
		switch(key) {
		case "forename": {driver.findElement(By.id(foreName)).sendKeys(value); break;}
		
		case "email": {driver.findElement(By.id(email)).sendKeys(value);break;}
		
		case "message": {driver.findElement(By.id(message)).sendKeys(value);break;}
	
		}
	}

	
	public void clickOnSubmit() {
		driver.findElement(By.xpath(submitBtn)).click();
	}


	public void validsuccess() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ui-if='contactValidSubmit']/div")));
		
			String message = driver.findElement(By.xpath("//*[@ui-if='contactValidSubmit']/div")).getText();
			
			Assert.assertEquals(message, "Thanks Anu, we appreciate your feedback.");
		
	}

	public void clickonBack() {
		driver.findElement(By.xpath("//*[contains(text(),'Back')]")).click();
	}
	
	


}
