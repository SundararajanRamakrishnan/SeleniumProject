/**
 * This Test will Logout of the Application
 */
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
import com.training.pom.DeletePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.SuscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Logout {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		logoutPOM = new LogoutPOM(driver);
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
	public void validDeleteTest() throws InterruptedException {
	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(2000);
		logoutPOM.ClickUserIcon();
		boolean ExpInbox = true;
		boolean ActInbox = logoutPOM.GetDDOptionsInbox();
		Assert.assertEquals(ExpInbox, ActInbox);
		System.out.println("The Inbox is " + ExpInbox +"  " + ActInbox );
		boolean ExpCertify = true;
		boolean ActCertify = logoutPOM.GetDDOptionsCertificate();
		Assert.assertEquals(ExpCertify, ActCertify);
		System.out.println("The Certificate is " + ExpCertify +"  " + ActCertify );
		boolean ExpLogout = true;
		boolean ActLogout = logoutPOM.GetDDOptionsLogout();
		Assert.assertEquals(ExpLogout, ActLogout);
		System.out.println("The Logout is " + ExpLogout +"  " + ActLogout );
		logoutPOM.ClickDDOptionsLogout();
		Thread.sleep(2000);		
	}
}
