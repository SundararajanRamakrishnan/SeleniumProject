/**
 * The objective of this test is to validate an end to end scenario where user login's as a teacher and add a course and project,
 *  then user login's as a Student and subscribes the course and projects and finally user login's as an admin and pulls up the report
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
import com.training.generics.ScreenShot;
import com.training.pom.SelectClassCoursePOM;
import com.training.pom.SignUpExcelPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author IBM
 *
 */
public class TC86Test {
	
	private WebDriver driver;
	private String baseUrl;
	private SelectClassCoursePOM selectclasscoursePOM;
	private ScreenShot screenShot;
	private static Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		selectclasscoursePOM = new SelectClassCoursePOM(driver);
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
	public void Validtests() throws InterruptedException
	{
		selectclasscoursePOM.SendUserName("reva");
		selectclasscoursePOM.SendPassword("reva");
		selectclasscoursePOM.ClickLoginBtn();
		selectclasscoursePOM.ClickCreateCourseLink();
		selectclasscoursePOM.EnterCourseNameTextbox("OnlinetestOnSeleniumWebDriver");
		selectclasscoursePOM.ClickAdvancedSettingsLink();
		selectclasscoursePOM.SelectCategoryFromDD("Projects");
		selectclasscoursePOM.EnterCourseRequested("OnlinetestOnSeleniumWebDriver");
		selectclasscoursePOM.SelectLanguageFromDD("English");
		selectclasscoursePOM.ClickAddCourseButton();
		selectclasscoursePOM.ClickAddIconButton();
		selectclasscoursePOM.EnterIntroductionText("Test");
		selectclasscoursePOM.ClickSaveIntroTextButton();
		selectclasscoursePOM.ClickCourseDescIcon();
		selectclasscoursePOM.ClickDescIcon();
		selectclasscoursePOM.EnterTitleAndDescTextbox("Test", "Test");
		selectclasscoursePOM.ClickDescSaveButton();
		selectclasscoursePOM.ClickObjectiveIcon();
		selectclasscoursePOM.EnterObjectivesTextbox("Test","Test");
		selectclasscoursePOM.ClickObjSaveButton();
		selectclasscoursePOM.ClickTopicsIcon();
		selectclasscoursePOM.EnterTopicsTextbox("Test","Test");
		selectclasscoursePOM.ClickTopicSaveButton();
		selectclasscoursePOM.ClickMyCoursesLink();
		selectclasscoursePOM.ClickMyAddedCourseLink();
		selectclasscoursePOM.ClickProjectIcon();
		selectclasscoursePOM.ClickNewProjectIcon();
		selectclasscoursePOM.EnterTitleAndsubTitle("Test","Test");
		
		
		//To compare the success message
		boolean ExpMsg = true;
		boolean ActMsg = selectclasscoursePOM.SuccessMsg();
		Assert.assertEquals(ExpMsg, ActMsg);
		System.out.println("The Success Message is Displayed " + ExpMsg + " " + ActMsg);
		
		selectclasscoursePOM.ClickAddedProjectLink();
		
		//To verify if Welcome Message is displayed
		String ExpWelMsg = "Welcome !";
		String ActWelMsg = selectclasscoursePOM.getWelcomeMsg();
		Assert.assertEquals(ExpWelMsg, ActWelMsg);
		System.out.println("The Welcome Message Displayed is " + ExpWelMsg + " " + ActWelMsg);
		
		//To Click on New Task Icon
		selectclasscoursePOM.ClickNewTaskIcon();
		selectclasscoursePOM.EnterNewTaskTextbox("OnlinetestOnSeleniumWebDriver");
		
		//To Click on Role Management and new Role Icon
		selectclasscoursePOM.ClickRoleMgmtAndNewRole();
		selectclasscoursePOM.EnterNewRoleTextBox("OnlinetestOnSeleniumWebDriver");
		
		//To Click in Assign a Role Icon
		selectclasscoursePOM.ClickAssignRoleIcon();
		
		//To Verify if User Role is displayed
		boolean ExpRole = true;
		boolean ActRole = selectclasscoursePOM.UserRoleIsDisplayed();
		Assert.assertEquals(ExpRole, ActRole);
		System.out.println("The User Role displayed is " + ExpRole + " " + ActRole);
		
		//To Verify if Task is displayed
		boolean ExpTask = true;
		boolean ActTask = selectclasscoursePOM.TaskIsDisplayed();
		Assert.assertEquals(ExpRole, ActRole);
		System.out.println("The Task displayed is " + ExpTask + " " + ActTask);
		
		selectclasscoursePOM.ClickValidateButton();
		
		
		selectclasscoursePOM.ClickUserMgmt();
		selectclasscoursePOM.ClickUserCheckbox();
		
		//To verify if User Check-box is selected
		boolean Expchk = true;
		boolean Actchk = selectclasscoursePOM.UserCheckboxIsSelected();
		Assert.assertEquals(Expchk, Actchk);
		System.out.println("The User Checkbox is selected " + Expchk + " " + Actchk);
			
		//Logging in as a Student
		selectclasscoursePOM.ClickLogOutButton();
		selectclasscoursePOM.SendUserName("sundarashok69");
		selectclasscoursePOM.SendPassword("avan2014");
		selectclasscoursePOM.ClickLoginBtn();
		
		//Clicking Course catalog and selecting subscribe button 
		selectclasscoursePOM.ClickCourseCatalog();
		selectclasscoursePOM.EnterCourseSearchTextbox("OnlinetestOnSeleniumWebDriver");
		selectclasscoursePOM.ClickSearchButton();
		selectclasscoursePOM.ClickSubscribeButton();
		
		//Logging in as Admin
		selectclasscoursePOM.ClickLogOutButton();
		selectclasscoursePOM.SendUserName("admin");
		selectclasscoursePOM.SendPassword("admin@123");
		selectclasscoursePOM.ClickLoginBtn();
		
		//Clicking on Reporting tab
		selectclasscoursePOM.ClickReportTab();
		selectclasscoursePOM.ClickFollowingStudentsLink();
		selectclasscoursePOM.EnterKeyWordTextbox("Ashok");
		selectclasscoursePOM.ClickArrowIcon();
		selectclasscoursePOM.ClickLogOutButton();
	}

}
