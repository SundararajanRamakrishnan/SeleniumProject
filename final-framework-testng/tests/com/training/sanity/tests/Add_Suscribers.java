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

public class Add_Suscribers {
	
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
		suscribePOM = new SuscribePOM(driver);
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
	public void validSuscribeTest() throws InterruptedException {
	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//Thread.sleep(5000);
		adminPOM.AddClassLink();
		Thread.sleep(5000);
		adminPOM.ViewTable();
		Thread.sleep(4000);
		suscribePOM.ClickAddSuscribe();
		/*
		boolean ExpectedText = true;
		boolean ActualText = suscribePOM.TextDisplay();
		Assert.assertEquals(ExpectedText, ActualText);
		*/
		Thread.sleep(3000);
		suscribePOM.SelMultipleUsers();
		suscribePOM.ClickSuscribeButton();
		String ExpUsers = "2";
		String ActUsers = suscribePOM.UsersSuscribed();
		Assert.assertEquals(ExpUsers, ActUsers);
		System.out.println("The Suscribers are " + ExpUsers +"  " + ActUsers );
	}


}
