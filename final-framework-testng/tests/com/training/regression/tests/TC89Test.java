/**
 * The objective of this test is to allow Users SignUp using Valid Credentials by fetching data from DB;
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

import com.training.dataproviders.ELTD74;
import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.SignUpDbPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Sundararajan R
 *
 */

public class TC89Test {
	
	private WebDriver driver;
	private String baseUrl;
	private SignUpDbPOM signupdbPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupdbPOM = new SignUpDbPOM(driver);
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
	
		
	@Test (dataProvider = "db-inputs", dataProviderClass = RegistrationDataProviders.class)
	public void SignUpTests(String firstName, String lastName, String email, String username,String password, String Cpassword, String phone, String lang) throws InterruptedException 		
	{
	signupdbPOM.ClickSignUpLink();	
	
	//To Verify the First Name is same between DB and Application
	System.out.println(firstName);		
	signupdbPOM.EnterFirstNameTextBox("Avan");
	String ExpFName= signupdbPOM.getFirstNameTextBox("value");
	System.out.println(ExpFName);
	String ActFName= firstName;
	Assert.assertEquals(ActFName, ExpFName);
	System.out.println("The First Name is " + ActFName + " " + ExpFName);
	
	//To Verify the Last Name is same between DB and Application
	System.out.println(lastName);
	signupdbPOM.EnterLastNameTextBox("Sundar");
	String ActLName= lastName;
	String ExpLName= signupdbPOM.getLastNameTextBox("value");
	System.out.println(ExpLName);
	Assert.assertEquals(ActLName, ExpLName);
	System.out.println("The Last Name is " + ActLName + " " + ExpLName);
	
	//To Verify the Email is same between DB and Application
	System.out.println(email);
	signupdbPOM.EnterEmailTextBox("avansundar@gmail.com");
	String ActEmail= email;
	String ExpEmail= signupdbPOM.getEmailTextBox("value");
	System.out.println(ExpEmail);
	Assert.assertEquals(ActEmail, ExpEmail);
	System.out.println("The Email is " + ActEmail + " " + ExpEmail);
	
	//To Verify the User name is same between DB and Application
	System.out.println(username);
	signupdbPOM.EnterUserNameTextBox("avansundar");
	String ActUName= username;
	String ExpUName= signupdbPOM.getUserNameTextBox("value");
	System.out.println(ExpUName);
	Assert.assertEquals(ActUName, ExpUName);
	System.out.println("The User Name is " + ActUName + " " + ExpUName);
	
	//To Verify the Password is same between DB and Application
	System.out.println(password);
	signupdbPOM.EnterPasswordTextBox("avan2014");
	String ActPwd= password;
	String ExpPwd= signupdbPOM.getPasswordTextBox("value");
	System.out.println(ExpPwd);
	Assert.assertEquals(ActPwd, ExpPwd);
	System.out.println("The Password is " + ActPwd + " " + ExpPwd);
	
	//To Verify Confirm Password is same between DB and Application
	System.out.println(Cpassword);
	signupdbPOM.EnterConfirmPasswordTextBox("avan2014");
	String ActCPwd= Cpassword;
	String ExpCPwd= signupdbPOM.getConfirmPasswordTextBox("value");
	System.out.println(ExpCPwd);
	Assert.assertEquals(ActCPwd, ExpCPwd);
	System.out.println("The Confirm Password is " + ActCPwd + " " + ExpCPwd);
	
	//To Verify the Phone Number is same between DB and Application
	System.out.println(phone);
	signupdbPOM.EnterPhoneTextBox("9115691156");
	String Actphone= phone;
	String Expphone= signupdbPOM.getPhoneTextBox("value");
	System.out.println(Expphone);
	Assert.assertEquals(Actphone, Expphone);
	System.out.println("The Phone Number is " + Actphone + " " + Expphone);
	
	//To Verify the Language is same between DB and Application
	System.out.println(lang);
	signupdbPOM.SelectLanguageFromDD("English");
	String Actlang= lang;
	String Explang= signupdbPOM.getSelectLanguage("value");
	System.out.println(Explang);
	Assert.assertEquals(Actlang, Explang);
	System.out.println("The Language is " + Actlang + " " + Explang);
	
	//To Verify if Student is selected in the profile 
	signupdbPOM.ProfileRadioButton();
	boolean Expected = true;
	boolean Actual = signupdbPOM.StudentRadioButtonIsSelected();
	Assert.assertEquals(Expected, Actual);
	System.out.println("The Student Profile is Selected " + Expected + " " + Actual);
	
	/*
	signupdbPOM.ClickRegistrationButton();
	 boolean ExpMsg = true;
	boolean ActMsg = signupdbPOM.GetSuccessMessage();
	Assert.assertEquals(ExpMsg, ActMsg);
	System.out.println("The Success Message is Displayed " + ExpMsg + " " + ActMsg);
	
	signupdbPOM.ClickLogOutButton();
	*/
	}

}
