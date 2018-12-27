/**
 * The objective of this Test is to Add Courses and Sessions to the E-learning Application
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
import com.training.pom.AddCourseSessionPOM;
import com.training.pom.AddPromotionsCareerPOM;
import com.training.pom.AdminPOM;
import com.training.pom.CoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Sundararajan R
 *
 */
public class TestCase58 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCourseSessionPOM addcoursesessionPOM;
	private SuscribePOM suscribePOM;
	private ScreenShot screenShot;
	private AdminPOM adminPOM;
	private CoursePOM coursePOM;
	private static Properties properties;
			
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 				
			addcoursesessionPOM = new AddCourseSessionPOM(driver);
			adminPOM = new AdminPOM(driver);
			suscribePOM = new SuscribePOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			coursePOM = new CoursePOM(driver);
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
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		addcoursesessionPOM.ClickCreateCourse();
		addcoursesessionPOM.EnterCourseTitle("Testing");
		boolean Expected = true; 
		boolean Actual = addcoursesessionPOM.GetCourseTitle();
		System.out.println("The Title displayed " + Expected + " " + Actual);
		addcoursesessionPOM.EnterCodeText("tes");
		addcoursesessionPOM.SelectTeachers("Manzoor");
		addcoursesessionPOM.SelectLanguage("English");
		addcoursesessionPOM.ClickCreateCourseButton();
		addcoursesessionPOM.ClickAdminLink();
		addcoursesessionPOM.ClickAddTrainingLink();
		addcoursesessionPOM.EnterSessionName("selenium training Demo");
		boolean Expectedtext = true;
		boolean Actualtext = addcoursesessionPOM.GetSessionName();
		System.out.println("The Session Name is " + Expectedtext + " " + Actualtext );
		addcoursesessionPOM.ClickAddSession();
		addcoursesessionPOM.SelectUsers();
		addcoursesessionPOM.ClickForwardButton();
		addcoursesessionPOM.ClickNextStepButton();
		addcoursesessionPOM.SelectUserFromList("Su");
		addcoursesessionPOM.ClickFinishSession();
		Thread.sleep(3000);
		screenShot.captureScreenShot();		
	}	

}
