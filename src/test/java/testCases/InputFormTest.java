package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InputFormSubmitPage;
import utilities.DataUtil;

public class InputFormTest extends BaseTest {
	
	
	@Test(priority = 1, dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void testEmptyFormSubmission(String browser, String runMode, String webLink) {
		
		if(runMode.equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run Mode is No");
		}
		setUp(browser, webLink);
		
		InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
		
		inputFormSubmitPage.clickSubmit();
		
        String validationMessage = inputFormSubmitPage.checkValidationMessagePopup();
        
        Assert.assertEquals(validationMessage, "Please fill out this field.");
		
	}
	
	@Test(priority = 2, dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void testFilledFormSubmission(String browser, String runMode, String webLink) {
		
		if(runMode.equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run Mode is No");
		}
		setUp(browser, webLink);
		
		InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
		
		inputFormSubmitPage.fillInputForm();
		inputFormSubmitPage.clickSubmit();
		
		boolean submissionStatus = inputFormSubmitPage.formSubmissionStatus();
		
		if(submissionStatus==true) {
			System.out.println("Form submitted");
		}else {
			Assert.assertTrue(false, "Form submission failed");
		}

		Assert.assertTrue(true, "Form submitted successfully");
		
	}

}
