package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class SimpleFormDemoPage extends BasePage {

	public SimpleFormDemoPage(WebDriver driver) {
		super(driver);
	}

	public boolean checkSimpleFormDemoPageURL() {
		
		String actualURL = driver.getCurrentUrl();
		if(actualURL.contains("")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public String enterMessageAndGetActualMessage(String expectedMessage) {
		
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(expectedMessage);
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		String actualMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
		return(actualMessage);
		
	}

}
