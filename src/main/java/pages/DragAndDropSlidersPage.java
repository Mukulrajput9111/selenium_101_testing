package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class DragAndDropSlidersPage extends BasePage {

	public DragAndDropSlidersPage(WebDriver driver) {
		super(driver);
	}

	public int changeAndGetDefaultValue15SliderValue(int offset) {
		
		WebElement slider15 = driver.findElement(By.xpath("//input[@value='15']"));
		
		Actions action = new Actions(driver);
		
		slider15.click();
		action.clickAndHold(slider15).moveByOffset(offset, 0).release().build().perform();
		
		int value = Integer.parseInt(driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText());
		return(value);
		
	}

}
