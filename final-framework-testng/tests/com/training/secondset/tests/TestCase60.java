/**
 * The objective of this Test is to Add Users and Subscribers to the E-learning Application
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
import com.training.pom.AddUserSuscribeUser;
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
public class TestCase60 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCourseSessionPOM addcoursesessionPOM;
	private AddUserSuscribeUser addusersuscribeuser;
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
			addusersuscribeuser = new AddUserSuscribeUser(driver);
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
		addusersuscribeuser.ClickAddUser();
		addusersuscribeuser.EnterFirstNameInTextBox("SampleFirst");
		addusersuscribeuser.EnterLastNameInTextBox("SampleLast");
		addusersuscribeuser.EnterEmailInTextBox("abc@gmail.com");
		addusersuscribeuser.EnterPhoneInTextBox("9999999999");
		addusersuscribeuser.EnterLoginIdInTextBox("firstlast");
		Thread.sleep(3000);
		
		addusersuscribeuser.SelectManualRadioButton();
		
		//To verify if Manual Radio Button is Selected
		boolean Expected = true;
		boolean Actual = addusersuscribeuser.ManualRadioBtnIsSelected();
		Assert.assertEquals(Expected, Actual);
		System.out.println("The Radio button selected is " + Expected + " " + Actual);
		
		//addusersuscribeuser.scrolldownpage();
		addusersuscribeuser.ClickProfileDropDown();
		addusersuscribeuser.SelectProfileOptions();
				
		addusersuscribeuser.ClickAddButton();
		addusersuscribeuser.ClickAdminLink();
		
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
		
		
		coursePOM.SwitchWindows();
		coursePOM.SelectCourses();
		coursePOM.ClickSuscribeCourseButton();		
		boolean ExpCourses = true;
		boolean ActCourses = coursePOM.CoursesSuscribed();
		Assert.assertEquals(ExpUsers, ActUsers);
		System.out.println("The Courses Opted are " + ExpCourses +"  " + ActCourses );
		
		
	}

}
