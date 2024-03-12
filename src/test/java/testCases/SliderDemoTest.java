package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DragAndDropSlidersPage;
import pages.SeleniumPlaygroundPage;
import utilities.DataUtil;

public class SliderDemoTest extends BaseTest {
	

	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void sliderDemoTest(String browser, String runMode, String webLink){
		
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("Skipping the test as the Run Mode is NO");
		}
		
		setUp(browser, webLink);
		
		SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
		seleniumPlaygroundPage.goToDragAndDropSliders();
		
		DragAndDropSlidersPage dragDropSliderPage = new DragAndDropSlidersPage(driver);
		int value = dragDropSliderPage.changeAndGetDefaultValue15SliderValue(215);
		if(value==95) {
			System.out.println("Values matched, Testcase passed");
		}else {
			System.out.println("Testcase failed again");
			driver.quit();
			Assert.fail();
		}
		
		driver.quit();
		
	}

}
