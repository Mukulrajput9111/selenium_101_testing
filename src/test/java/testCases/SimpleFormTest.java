package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SeleniumPlaygroundPage;
import pages.SimpleFormDemoPage;
import utilities.DataUtil;

public class SimpleFormTest extends BaseTest {
	
	public String expectedMessage = "Just a sample message for testing this demo page";
	
	@Test(priority = 1, dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void validateSimpleFormPageURL(String browser, String runMode, String webLink) {
		
		if(runMode.equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run Mode is No");
		}
		setUp(browser, webLink);
		
		SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
		seleniumPlaygroundPage.goToSimpleFormDemo();
		
		SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);
		Boolean validateURL = simpleFormDemoPage.checkSimpleFormDemoPageURL();
		
		if(!validateURL) {
			Assert.fail("Actual URL didn't match the expected URL");
		}
		
		System.out.println("Actual URL matched with the expected URL");
		
	}
	
	@Test(priority = 2, dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void validateSimpleFormSubmission(String browser, String runMode, String webLink) {
		
		if(runMode.equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run Mode is No");
		}
		setUp(browser, webLink);
		
		SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
		seleniumPlaygroundPage.goToSimpleFormDemo();
		
		SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);
		String actualMessage = simpleFormDemoPage.enterMessageAndGetActualMessage(expectedMessage);
		if(!actualMessage.equals(expectedMessage)) {
			Assert.fail("Form failed as the Actual message failed to match Expected message");
		}
		
		System.out.println("Actual message matched with the Expected message");
		
	}
	

}
