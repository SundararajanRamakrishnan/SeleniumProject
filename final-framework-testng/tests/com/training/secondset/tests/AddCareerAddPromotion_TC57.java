/**
 * The objective of this Test is to Add Promotions and Careers to the E-learning Application
 */
package com.training.secondset.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AddPromotionsCareerPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Sundararajan R
 *
 */
public class AddCareerAddPromotion_TC57 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddPromotionsCareerPOM addpromotionscareerPOM;
	private ScreenShot screenShot;
	private static Properties properties;
			
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 	
			addpromotionscareerPOM = new AddPromotionsCareerPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);					
	}				
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();	
		Thread.sleep(5000);
		screenShot.captureScreenShot("First");
		addpromotionscareerPOM.ClickCareerPromotionLink();
		addpromotionscareerPOM.ClickCareerIcon();
		addpromotionscareerPOM.ClickAddIcon();
		addpromotionscareerPOM.EnterNameInCareerTextbox("Sample");
		addpromotionscareerPOM.ClickCareerAddButton();
		addpromotionscareerPOM.GetMessageText();
		boolean Expected = true;
		boolean Actual = addpromotionscareerPOM.GetMessage();
		Assert.assertEquals(Expected, Actual);
		System.out.println("The Values after adding is " + Expected + " " + Actual);
		
		addpromotionscareerPOM.ClickAdminTab();
		addpromotionscareerPOM.ClickCareerPromotionLink();
		addpromotionscareerPOM.ClickPromotionsIcon();
		addpromotionscareerPOM.AddPromotionsIcon();
		addpromotionscareerPOM.EnterNameInPromotionTextbox("QA for Tester");
		addpromotionscareerPOM.ClickPromotionAddButton();
		addpromotionscareerPOM.AddTrainingIcon();
		addpromotionscareerPOM.EnterSessionNameInTextbox("selenium training session on Windows handling");
		addpromotionscareerPOM.ClickSessionAddButton();
		addpromotionscareerPOM.SelectCourses();
		addpromotionscareerPOM.ClickForwardButton();
		addpromotionscareerPOM.ClickNextStepButton();
		addpromotionscareerPOM.SelectUserFromList("Su");
		addpromotionscareerPOM.ClickFinishSessionCreation();
		screenShot.captureScreenShot("TC57_Final");
		
	}	
}
