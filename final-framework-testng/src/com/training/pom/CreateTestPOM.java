/**
 * The objective of this POM is to Login as a teacher and create a test for the students
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sundararajan R
 *
 */
public class CreateTestPOM {

	private WebDriver driver;

	public CreateTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//section[@id='page']/div/div[2]//h4/a")
	private WebElement courselink;
	
	@FindBy(xpath="//img[@title='Tests']")
	private WebElement testicon;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement createtest;
	
	@FindBy(xpath="//input[@id='exercise_title']")
	private WebElement testname;
	
	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement advancedsettings;
	
	@FindBy(xpath= "//label[contains(text(),'Give a context to the test')]")
	private WebElement label1;
	
	@FindBy(xpath= "//label[contains(text(),'Show score to learner')]")
	private WebElement label2;
	
	@FindBy(xpath= "//label[contains(text(),'Pass percentage')]")
	private WebElement label3;
	
	@FindBy(xpath="//input[@id='exerciseType_0']")
	private WebElement feedbackradio;
	
	@FindBy(xpath="//input[@name='activate_start_date_check']")
	private WebElement starttime;
	
	@FindBy(xpath="//p[@id='start_time_alt_text']")
	private WebElement starttimedisplay;
	
	@FindBy(xpath="//*[@id='start_date_div']/div/div[1]/div/span[1]/img")
	private WebElement startclock;
	
	@FindBy(xpath="//input[@id='pass_percentage']")
	private WebElement passpercentage;
	
	@FindBy(xpath="//button[@id='exercise_admin_submitExercise']")
	private WebElement proceedtoquestions;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg;
	
	@FindBy(xpath="//img[@title='Multiple choice']")
	private WebElement multiplechoice;
	
	@FindBy(xpath="//input[@name='questionName']")
	private WebElement enterquestion;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[1]']")
	private WebElement firstanswer;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[2]']")
	private WebElement secondanswer;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[3]']")
	private WebElement thirdanswer;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[4]']")
	private WebElement fourthanswer;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']//tbody/tr[1]/td[2]/input")
	private WebElement firstradiobtn;
	
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement submitquestion;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement alertmsg;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']//tbody/tr[2]/td[2]/input")
	private WebElement secondradiobtn;
	
	@FindBy(xpath="//img[@title='Preview']")
	private WebElement previewicon;
	
	@FindBy(xpath="//a[contains(text(),'Start test')]")
	private WebElement startest;
	
	@FindBy(xpath = "//li[@class='dropdown avatar-user']/a/img")
	private WebElement ClickUser;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[5]/a")
	private WebElement DDOptionLogout;
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement coursecatlink;
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement coursesearch;
	
	@FindBy(xpath="//div[@class='input-group-btn']/button")
	private WebElement searchbutton;
	
	@FindBy(xpath="//div[@class='btn-group']/a")
	private WebElement subscribebutton;
	
	@FindBy(xpath="//a[contains(text(),'JavaOnlineTest')]")
	private WebElement clickcourse;
	
	@FindBy(xpath="//img[@title='Tests']")
	private WebElement testsicon;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover']//a")
	private WebElement testslink;
	
	@FindBy(xpath="//a[contains(text(),'Start test')]")
	private WebElement startestbutton;
	
	@FindBy(xpath="//div[@class='question_options']/label[1]/input")
	private WebElement firstoption;
	
	@FindBy(xpath="//button[contains(text(),'Next question')]")
	private WebElement nextbutton;
	
	@FindBy(xpath="//div[@class='question_options']/label[2]/input")
	private WebElement secondoption;
	
	@FindBy(xpath="//button[contains(text(),'End test')]")
	private WebElement endtestbutton;
	
	@FindBy(xpath="//div[@class='question_row_score']//h3")
	private WebElement quizscore;
	
	public void SendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void SendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void ClickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void ClickCourseLink()
	{
		this.courselink.click();
	}
	
	public void ClickTestIcon()
	{
		this.testicon.click();
	}
	
	public void ClickCreateTestButton()
	{
		this.createtest.click();
	}
	
	public void ClickAdvancedSettingsButton()
	{
		this.advancedsettings.click();
	}
	
	public void EnterTestNameTextbox(String value)
	{
		this.testname.clear();
		this.testname.sendKeys(value);
	}
	
	public String GetLabel1Text()
	{
		String label1 = this.label1.getText();
		return label1;		
	}
	
	public String GetLabel2Text()
	{
		String label2 = this.label2.getText();
		return label2;		
	}
	
	public String GetLabel3Text()
	{
		String label3 = this.label3.getText();
		return label3;		
	}
	
	public boolean FeedbackRadioButtonIsSelected()
	{
		if (this.feedbackradio.isSelected())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public boolean StartTimeIsDisplayed()
	{
		//this.starttime.click();
		
		if (this.starttimedisplay.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void EnterPassPercentageTextbox(String value)
	{
		this.passpercentage.clear();
		this.passpercentage.sendKeys(value);
	}
	
	public void ClickProceedQuestions()
	{
		this.proceedtoquestions.click();
	}
	
	public String GetSuccessMsg()
	{
		String msg = this.successmsg.getText();
		return msg;
	}
	
	public void ClickMutipleChoiceQuestions()
	{
		this.multiplechoice.click();
	}
	
	public void EnterQuestionTextbox(String value)
	{
		this.enterquestion.clear();
		this.enterquestion.sendKeys(value);
	}
	
	public void ClickAndEnterFirstOption(String value)
	{
		WebElement frame = this.firstanswer;		
		new Actions(driver).click(frame).sendKeys(frame, value).build().perform();		
	}
	
	public void ClickAndEnterSecondOption(String value)
	{
		WebElement frame = this.secondanswer;		
		new Actions(driver).click(frame).sendKeys(frame, value).build().perform();		
	}
	
	public void ClickAndEnterThirdOption(String value)
	{
		WebElement frame = this.thirdanswer;		
		new Actions(driver).click(frame).sendKeys(frame, value).build().perform();		
	}
	
	public void ClickAndEnterFourthOption(String value)
	{
		WebElement frame = this.fourthanswer;		
		new Actions(driver).click(frame).sendKeys(frame, value).build().perform();		
	}
	
	public boolean FistOptionIsSelected()
	{
		if (this.firstradiobtn.isSelected())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void ClickSubmitQuestionButton()
	{
		this.submitquestion.click();
	}
	
	public boolean AlertMessageIsDisplayed()
	{
		if(this.alertmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean SecondOptionIsSelected()
	{
		this.secondradiobtn.click();
		
		if (this.secondradiobtn.isSelected())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void ClickPreviewIcon()
	{
		this.previewicon.click();
	}
	
	public boolean  StartTestIsEnabled()
	{
		if(this.startest.isEnabled())
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	
	public void ClickLogOutButton()
	{
		this.ClickUser.click();
		this.DDOptionLogout.click();
	}
	
	public void ClickCourseCatalog()
	{
		this.coursecatlink.click();
	}
	
	public void EnterCourseSearchTextbox(String value)
	{
		this.coursesearch.clear();
		this.coursesearch.sendKeys(value);
	}
	
	public void ClickSearchButton()
	{
		this.searchbutton.click();
	}
	
	public void ClickSubscribeButton()
	{
		this.subscribebutton.click();
	}
	
	public void ClickCourseLinkbutton()
	{
		this.clickcourse.click();
	}	
	
	public void ClickTestsIcon()
	{
		this.testsicon.click();
	}
	
	public void ClickTestsLink()
	{
		this.testslink.click();
	}
	
	public void ClickStartTestButton()
	{
		this.startestbutton.click();
	}
	
	public void ExplicitWaitOnElement()
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(this.startestbutton));
		element.click();
	}	
	
	public void ClickFirstOption()
	{
		this.firstoption.click();
	}
	
	public void ClickNextButton()
	{
		this.nextbutton.click();
	}	
	
	public void ClickSecondOption()
	{
		this.firstoption.click();
	}
	
	public void ClickEndTestButton()
	{
		this.endtestbutton.click();
	}
	
	public boolean ResultPageIsDisplayed()
	{
		if(this.quizscore.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
