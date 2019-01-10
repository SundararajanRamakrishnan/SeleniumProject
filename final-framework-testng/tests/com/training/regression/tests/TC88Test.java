/**
 * The objective of this test is to allow Users SignUp using Invalid Credentials by fetching data from excel
 */


package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.ELTD75;
import com.training.generics.ScreenShot;
import com.training.pom.SignUpExcelPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Sundararajan R
 *
 */

public class TC88Test {
	private WebDriver driver;
	private String baseUrl;
	private SignUpExcelPOM signupexcelPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupexcelPOM = new SignUpExcelPOM(driver);
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
	
		
	@Test (dataProvider = "ELTD75", dataProviderClass = ELTD75.class)
	//@Test
	public void SignUpTests(String firstName, String lastName, String email, String username,String password, String Cpassword, String phone, String lang) throws InterruptedException 		
	//public void SignUpTests()
	{
	signupexcelPOM.ClickSignUpLink();
	
	System.out.println(firstName);	
	signupexcelPOM.EnterFirstNameTextBox(firstName);
	//Thread.sleep(2000);
	System.out.println(lastName);
	signupexcelPOM.EnterLastNameTextBox(lastName);
	System.out.println(email);
	signupexcelPOM.EnterEmailTextBox(email);
	System.out.println(username);
	signupexcelPOM.EnterUserNameTextBox(username);
	System.out.println(password);
	signupexcelPOM.EnterPasswordTextBox(password);
	System.out.println(Cpassword);
	signupexcelPOM.EnterConfirmPasswordTextBox(Cpassword);
	System.out.println(phone);
	signupexcelPOM.EnterPhoneTextBox(phone);
	System.out.println(lang);
	signupexcelPOM.SelectLanguageFromDD(lang);
	signupexcelPOM.ProfileRadioButton();
	boolean Expected = true;
	boolean Actual = signupexcelPOM.StudentRadioButtonIsSelected();
	Assert.assertEquals(Expected, Actual);
	System.out.println("The Student Profile is Selected " + Expected + " " + Actual);
	signupexcelPOM.ClickRegistrationButton();
	boolean ExpMsg = true;
	boolean ActMsg = signupexcelPOM.GetSuccessMessage();
	Assert.assertEquals(ExpMsg, ActMsg);
	System.out.println("The Success Message is Displayed " + ExpMsg + " " + ActMsg);
	Thread.sleep(3000);
	//driver.navigate().back();
	driver.get(baseUrl);
	Thread.sleep(3000);
	
	
	}

}
