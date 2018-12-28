/**
 * The objective of this Test is to Add Courses and Sessions to the E-learning Application
 */
package com.training.secondset.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddCourseSessionPOM;
import com.training.pom.AdminPOM;
import com.training.pom.CoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author IBM
 *
 */
public class CreateCourseSubscriberUser_TC59 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCourseSessionPOM addcoursesessionPOM;
	private SuscribePOM suscribePOM;
	private ScreenShot screenShot;
	private AdminPOM adminPOM;
	private CoursePOM coursePOM;
	private GenericMethods genericmethods;
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
			genericmethods = new GenericMethods(driver);
			// open the browser 
			driver.get(baseUrl);					
	}				
	
	/*
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	*/
	
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();	
		Thread.sleep(2000);
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
		
		adminPOM.AddClassLink();
		adminPOM.AddClassNameIcon();
		adminPOM.EnterTextInCourseName("Demo");
		adminPOM.EnterTextInCourseDesc("Demo");
		
		String ExpCourseName = "Demo";
		String ActCourseName = adminPOM.GetTextFromCourseName();
		Assert.assertEquals(ExpCourseName, ActCourseName);
		System.out.println("The CourseName is " + ExpCourseName +"  " + ActCourseName );
		
		boolean ExpCName = true;
		boolean ActCName = adminPOM.VerifyClassName();
		Assert.assertEquals(ExpCName, ActCName);
		System.out.println("The CourseDesc is " + ExpCName +"  " + ActCName );
		
		adminPOM.SelectGroupPermissions();
	    boolean ExpDisplay = true;
		boolean ActDisplay =  adminPOM.SelValueIsDisplayed();
		Assert.assertEquals(ExpDisplay, ActDisplay);
		System.out.println("The options is " + ExpDisplay +"  " + ActDisplay );		
		
		adminPOM.ClickAddButton();
		adminPOM.ViewTable();
		Thread.sleep(4000);
		
		suscribePOM.ClickAddSuscribe();
		Thread.sleep(3000);
		suscribePOM.SelMultipleUsers();
		suscribePOM.ClickSuscribeButton();
		boolean ExpUsers = true;
		boolean ActUsers = suscribePOM.UsersSuscribed();
		Assert.assertEquals(ExpUsers, ActUsers);
		System.out.println("The Suscribers are " + ExpUsers +"  " + ActUsers );	
		
		/*
		addcoursesessionPOM.ClickAdminLink();
		adminPOM.AddClassLink();
		adminPOM.ViewTable();
		*/
		Thread.sleep(2000);
		//coursePOM.ClickAddCourse();
		
		
		Thread.sleep(2000);
		coursePOM.SwitchWindows();
		coursePOM.SelectCourses();
		coursePOM.ClickSuscribeCourseButton();		
		boolean ExpCourses = true;
		boolean ActCourses = coursePOM.CoursesSuscribed();
		Assert.assertEquals(ExpUsers, ActUsers);
		System.out.println("The Courses Opted are " + ExpCourses +"  " + ActCourses );
		screenShot.captureScreenShot("FinalPage");
	}
	

}
