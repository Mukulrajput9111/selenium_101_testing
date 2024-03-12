package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class InputFormSubmitPage extends BasePage{
	
	public InputFormSubmitPage(WebDriver driver) {
		super(driver);
	}

	public Properties inputFormSubmitPage = new Properties();
	public FileInputStream fis;
	
	public void clickSubmit() {
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
	}
	
	public void fillInputForm() {
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/inputFormSubmitPage.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			inputFormSubmitPage.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(inputFormSubmitPage.getProperty("Name"));
		
		driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys(inputFormSubmitPage.getProperty("Email"));
		
		driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys(inputFormSubmitPage.getProperty("Password"));
		
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(inputFormSubmitPage.getProperty("Company"));
		
		driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys(inputFormSubmitPage.getProperty("Website"));
		
		driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys(inputFormSubmitPage.getProperty("City"));
		
		driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys(inputFormSubmitPage.getProperty("Address1"));
		
		driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys(inputFormSubmitPage.getProperty("Address2"));
		
		driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys(inputFormSubmitPage.getProperty("State"));
		
		driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys(inputFormSubmitPage.getProperty("ZipCode"));
		
		WebElement countryChrome = driver.findElement(By.xpath("//select[@name='country']"));
		
		Select selectChrome = new Select(countryChrome);
		
		selectChrome.selectByVisibleText(inputFormSubmitPage.getProperty("Country"));
		
	}
	
	public String checkValidationMessagePopup() {
		
		String validationMessage;
		
       try {
		WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
        validationMessage = nameField.getAttribute("validationMessage");
       }catch(Exception e){
    	   return "Dummy Message";
       }
       return validationMessage;
		
	}
	
	public boolean formSubmissionStatus() {
		
		String successString = "Thanks for contacting us, we will get back to you shortly.";
		
		boolean submissionStatus;
		try {
			submissionStatus = (driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText()).equals(successString);
		} catch (ElementNotInteractableException e) {
			submissionStatus = false;
		}
		
		return submissionStatus;
		
	}

}
