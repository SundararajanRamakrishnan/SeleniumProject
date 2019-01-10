/**
 * The objective of this test is to login as a teacher and create a test for the students and generate  report for the same
 */
package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 * @author Sundararajan R
 *
 */
public class TC90Test {
	
	private WebDriver driver;
	private String baseUrl;
	private CreateTestPOM createtestPOM;
	private ScreenShot screenShot;
	private static Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		createtestPOM = new CreateTestPOM(driver);
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
		createtestPOM.SendUserName("reva");
		createtestPOM.SendPassword("reva");
		createtestPOM.ClickLoginBtn();
		createtestPOM.ClickCourseLink();
		createtestPOM.ClickTestIcon();
		createtestPOM.ClickCreateTestButton();
		createtestPOM.EnterTestNameTextbox("sampleprogram");
		createtestPOM.ClickAdvancedSettingsButton();
		
		//To verify if fields are displayed after clicking on Advanced Settings button
		String ExpLabel1 = "Give a context to the test";
		String ActLabel1 = createtestPOM.GetLabel1Text();
		Assert.assertEquals(ExpLabel1, ActLabel1);
		System.out.println("The Label1 is " + ExpLabel1  +  " " +   ActLabel1);
		
		String ExpLabel2 = "Show score to learner";
		String ActLabel2 = createtestPOM.GetLabel2Text();
		Assert.assertEquals(ExpLabel2, ActLabel2);
		System.out.println("The Label2 is " + ExpLabel2  +  " " +   ActLabel2);
		
		String ExpLabel3 = "Pass percentage";
		String ActLabel3 = createtestPOM.GetLabel3Text();
		Assert.assertEquals(ExpLabel3, ActLabel3);
		System.out.println("The Label3 is " + ExpLabel3  +  " " +   ActLabel3);		
		
		//To Verify if At end of test is selected in Feedback section
		boolean Expfeedback = true;
		boolean Actfeedback = createtestPOM.FeedbackRadioButtonIsSelected();
		Assert.assertEquals(Expfeedback, Actfeedback);
		System.out.println("At End of Test Radio button is Selected " + Expfeedback + " "  + Actfeedback);
		
		//To Click on Start Time Check box and verify if Start time is displayed 
		boolean ExpStTime = false;
		boolean ActStTime = createtestPOM.StartTimeIsDisplayed();
		Assert.assertEquals(ExpStTime, ActStTime);
		System.out.println("At End of Test Radio button is Selected " + ExpStTime + " "  + ActStTime);
						
		//To Input the pass percentage value
		createtestPOM.EnterPassPercentageTextbox("50");
		
		createtestPOM.ClickProceedQuestions();
		
		//To verify if ExerciseAdded Msg is displayed
		String ExpMsg = "Exercise added";
		String ActMsg = createtestPOM.GetSuccessMsg();
		Assert.assertEquals(ExpMsg, ActMsg);
		System.out.println("The Message displayed is " + ExpMsg + " " + ActMsg);
		
		//To Enter the First question of the Quiz
		createtestPOM.ClickMutipleChoiceQuestions();
		createtestPOM.EnterQuestionTextbox("Test");
		createtestPOM.ClickAndEnterFirstOption("test1");
		createtestPOM.ClickAndEnterSecondOption("test2");
		createtestPOM.ClickAndEnterThirdOption("test3");
		createtestPOM.ClickAndEnterFourthOption("test4");
		
		//To verify if First Option is selected 
		boolean Expfirstoption = true;
		boolean Actfirstoption = createtestPOM.FistOptionIsSelected();
		Assert.assertEquals(Expfirstoption, Actfirstoption);
		System.out.println("The First Option Radio button is Selected " + Expfirstoption + " "  + Actfirstoption);
		
		createtestPOM.ClickSubmitQuestionButton();
		
		//To verify if Success Msg is displayed 
		boolean Expalertmsg = true;
		boolean Actalertmsg = createtestPOM.AlertMessageIsDisplayed();
		Assert.assertEquals(Expalertmsg, Actalertmsg);
		System.out.println("The Success Msg is displayed " + Expalertmsg + " "  + Actalertmsg);
		
		
		//To Enter the Second question of the Quiz
		createtestPOM.ClickMutipleChoiceQuestions();
		createtestPOM.EnterQuestionTextbox("Test2");
		createtestPOM.ClickAndEnterFirstOption("test1");
		createtestPOM.ClickAndEnterSecondOption("test2");
		createtestPOM.ClickAndEnterThirdOption("test3");
		createtestPOM.ClickAndEnterFourthOption("test4");
		
		//To verify if Second Option is selected 
		boolean Expsecondoption = true;
		boolean Actsecondoption = createtestPOM.SecondOptionIsSelected();
		Assert.assertEquals(Expsecondoption, Actsecondoption);
		System.out.println("The Second Option Radio button is Selected " + Expsecondoption + " "  + Actsecondoption);
		
		createtestPOM.ClickSubmitQuestionButton();
		
		//To Click on preview icon;
		createtestPOM.ClickPreviewIcon();
		
		//To verify if Start Test Button is enabled 
		boolean Expstart = true;
		boolean Actstart = createtestPOM.StartTestIsEnabled();
		Assert.assertEquals(Expstart, Actstart);
		System.out.println("The Start test is enabled " + Expstart + " "  + Actstart);
		
		//To Logout as a teacher;
		createtestPOM.ClickLogOutButton();
		
		//To Login as a student
		createtestPOM.SendUserName("studentsundar");
		createtestPOM.SendPassword("studentsundar");
		createtestPOM.ClickLoginBtn();
		
		//To Click on Course Catalog and select a value
		createtestPOM.ClickCourseCatalog();
		createtestPOM.EnterCourseSearchTextbox("JavaOnlineTest");
		createtestPOM.ClickSearchButton();
		createtestPOM.ClickSubscribeButton();
				
		createtestPOM.EnterCourseSearchTextbox("JavaOnlineTest");
		createtestPOM.ClickSearchButton();
		createtestPOM.ClickCourseLinkbutton();
		createtestPOM.ClickTestsIcon();
		createtestPOM.ClickTestsLink();	
		
		createtestPOM.ClickStartTestButton();
		createtestPOM.ClickFirstOption();
		createtestPOM.ClickNextButton();
		createtestPOM.ClickSecondOption();
		createtestPOM.ClickEndTestButton();
		
		//To verify if Start Test Button is enabled 
		boolean Expscore = true;
		boolean Actscore = createtestPOM.ResultPageIsDisplayed();
		Assert.assertEquals(Expscore, Actscore);
		System.out.println("The Result of the Quiz is displayed " + Expscore + " "  + Actscore);
		
		createtestPOM.ClickLogOutButton();
		
		/*createtestPOM.SendUserName("reva");
		createtestPOM.SendPassword("reva");
		createtestPOM.ClickLoginBtn();*/
		
		
		
		
		
		
		
}
}