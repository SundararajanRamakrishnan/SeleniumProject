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
import com.training.pom.CoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Add_Courses {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	private AdminPOM adminPOM;
	private SuscribePOM suscribePOM;
	private CoursePOM coursePOM;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminPOM = new AdminPOM(driver);
		suscribePOM = new SuscribePOM(driver);
		coursePOM = new CoursePOM(driver);
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
	public void validCourseTest() throws InterruptedException {
	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//Thread.sleep(5000);
		adminPOM.AddClassLink();
		Thread.sleep(5000);
		adminPOM.ViewTable();
		Thread.sleep(4000);
		coursePOM.ClickAddCourse();
		/*
		boolean ExpectedText = true;
		boolean ActualText = suscribePOM.TextDisplay();
		Assert.assertEquals(ExpectedText, ActualText);
		*/
		Thread.sleep(3000);
		coursePOM.SelectCourses();
		coursePOM.ClickSuscribeCourseButton();
		
		String ExpUsers = "1";
		String ActUsers = coursePOM.CoursesSuscribed();
		Assert.assertEquals(ExpUsers, ActUsers);
		System.out.println("The users are " + ExpUsers +"  " + ActUsers );
		
	}


}
