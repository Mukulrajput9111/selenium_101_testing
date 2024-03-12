package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class SeleniumPlaygroundPage extends BasePage {
	
	public SeleniumPlaygroundPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToSimpleFormDemo() {
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();
	}
	
	public void goToDragAndDropSliders() {
		driver.findElement(By.xpath("//a[normalize-space()='Drag & Drop Sliders']")).click();
	}
	
	public void goToInputFormSubmit() {
		driver.findElement(By.xpath("///a[normalize-space()='Input Form Submit']")).click();
	}

}
