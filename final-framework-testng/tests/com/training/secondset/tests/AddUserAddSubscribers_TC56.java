/**
 * The objective of this Test is to Add Courses and Subscribers to the E-learning Application
 */
package com.training.secondset.tests;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCourseSuscribersPOM;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

/**
 * @author Sundararajan R
 *
 */
public class AddUserAddSubscribers_TC56 {
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private AddCourseSuscribersPOM addcoursesuscribersPOM;
		private ScreenShot screenShot;
		private static Properties properties;
				
		@BeforeClass
		public void setUpBeforeClass() throws IOException {
				properties = new Properties();
				FileInputStream inStream = new FileInputStream("./resources/others.properties");
				properties.load(inStream);
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				loginPOM = new LoginPOM(driver); 	
				addcoursesuscribersPOM = new AddCourseSuscribersPOM(driver);
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
			addcoursesuscribersPOM.ClickSessionCategoryList();
			addcoursesuscribersPOM.ClickTrainingList();
			Thread.sleep(2000);
			addcoursesuscribersPOM.ClickSuscribersList();
			addcoursesuscribersPOM.SelectUserFromList("Su");
			Thread.sleep(2000);
			boolean Expected = true;
			boolean Actual = addcoursesuscribersPOM.UsersIsDisplayed();
			Assert.assertEquals(Expected, Actual);
			System.out.println("The Value of Assertion is " + Expected + " " + Actual);
			addcoursesuscribersPOM.ClickSuscribersSession();
			addcoursesuscribersPOM.GetPageTitle();
			addcoursesuscribersPOM.ClickAddCourse();
			addcoursesuscribersPOM.GetPageTitleText();
			addcoursesuscribersPOM.SelectUsers();
			addcoursesuscribersPOM.ClickForwardButton();
			addcoursesuscribersPOM.ClickAddCoursesButton();
		}
}
