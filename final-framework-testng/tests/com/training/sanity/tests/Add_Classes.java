package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Add_Classes {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	private AdminPOM adminPOM;
	private SuscribePOM suscribePOM;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminPOM = new AdminPOM(driver);
		//suscribePOM = new SuscribePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	/*
	@BeforeTest
	public void setUpTest() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminPOM = new AdminPOM(driver);
		suscribePOM = new SuscribePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	*/
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
	@Test
	public void validAdminTest() throws InterruptedException {
	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(5000);
	
		//adminPOM.ClickAdminLink();
		adminPOM.AddClassLink();
		adminPOM.AddClassNameIcon();
		adminPOM.EnterTextInCourseName("Demo");
		adminPOM.EnterTextInCourseDesc("Demo");
		
		//To Compare the Course Name
		String ExpCourseName = "Demo";
		String ActCourseName = adminPOM.GetTextFromCourseName();
		Assert.assertEquals(ExpCourseName, ActCourseName);
		boolean ExpCName = true;
		boolean ActCName = adminPOM.VerifyClassName();
		Assert.assertEquals(ExpCName, ActCName);
		System.out.println("The CourseName is " + ExpCName +"  " + ActCName );
		
		//To Compare the Course Desc
		String ExpCourseDesc = "Demo";
		String ActCourseDesc = adminPOM.GetTextFromCourseName();
		Assert.assertEquals(ExpCourseDesc, ActCourseDesc);
		boolean ExpCDesc = true;
		boolean ActCDesc = adminPOM.VerifyClassDesc();
		Assert.assertEquals(ExpCName, ActCName);
		System.out.println("The CourseDesc is " + ExpCDesc +"  " + ActCDesc );	
		
		//To Select the Group Permission
	      adminPOM.SelectGroupPermissions();
	      boolean ExpDisplay = true;
		  boolean ActDisplay =  adminPOM.SelValueIsDisplayed();
		  Assert.assertEquals(ExpDisplay, ActDisplay);
		  System.out.println("The options is " + ExpDisplay +"  " + ActDisplay );
		  
		 //To View the Added Class in the Table
		  adminPOM.ClickAddButton();
		  Thread.sleep(3000);
		  adminPOM.AddMessage();
		  adminPOM.ViewTable();
			
	}

}
