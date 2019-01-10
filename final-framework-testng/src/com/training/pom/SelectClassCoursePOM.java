/**
 * The objective of this POM is to validate an end to end scenario
 */
package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sundararajan R
 *
 */
public class SelectClassCoursePOM {
	
private WebDriver driver;

	public SelectClassCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Homepage')]")
	private WebElement homepagelink;
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createcourselink;
	
	@FindBy(id="title")
	private WebElement coursename;
	
	@FindBy(id="advanced_params")
	private WebElement advancedsettingslink;
	
	@FindBy(xpath="//button[@data-id='add_course_category_code']")
	private WebElement categorydd;
	
	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[1]/div[1]/div/div/div/input")
	private WebElement categorytextbox;
	
	@FindBy(xpath="//ul[@class='dropdown-menu inner']/li[@class='active']/a/span[1]")
	private WebElement categoryselected;
	
	@FindBy(id="add_course_wanted_code")
	private WebElement courserequested;
	
	@FindBy(xpath="//button[@data-id='add_course_course_language']")
	private WebElement langdd;
	
	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[3]/div[1]/div/div/div/input")
	private WebElement langtextbox;
	
	@FindBy(xpath="//ul[@class='dropdown-menu inner']/li[@class='selected active']/a/span[contains(text(),'English')]")
	private WebElement langselected;
	
	@FindBy(id="add_course_submit")
	private WebElement addcoursebutton;
	
	@FindBy(xpath="//div[@class='help-course']/a/em[@class='fa fa-file-text']")
	private WebElement addiconbutton;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement msgframe;
	
	@FindBy(xpath="//html/body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement msgbody;
	
	@FindBy(xpath="//button[@class=' btn btn-primary ' and @id='introduction_text_intro_cmdUpdate']")
	private WebElement saveintrotextbutton;
	
	@FindBy(xpath="//img[@title='Course description']")
	private WebElement coursedescicon;
	
	@FindBy(xpath="//img[@title='Description']")
	private WebElement descicon;
	
	@FindBy(id="course_description_title")
	private WebElement desctitle;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement desctitleframe;
	
	@FindBy(xpath="//html/body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement descmsgbody;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement descsavebutton;
	
	@FindBy(xpath="//img[@title='Objectives']")
	private WebElement objectivesicon;
	
	@FindBy(id="course_description_title")
	private WebElement objtitle;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement objtitleframe;
	
	@FindBy(xpath="//html/body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement objmsgbody;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement objsavebutton;
	
	@FindBy(xpath="//img[@title='Topics']")
	private WebElement topicicon;
	
	@FindBy(id="course_description_title")
	private WebElement topictitle;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement topictitleframe;
	
	@FindBy(xpath="//html/body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement topicmsgbody;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement topicsavebutton;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement mycourseslink;
	
	@FindBy(xpath="//section[@id='page']/div[@class='classic-courses']/div//h4/a[contains(text(),'OnlinetestOnSeleniumWebDriver')]")
	private WebElement myaddedcourselink;
	
	@FindBy(xpath="//img[@title='Projects']")
	private WebElement projecticon;
	
	@FindBy(xpath="//img[@title='Create a new project']")
	private WebElement newprojecticon;
	
	@FindBy(id="add_blog_blog_name")
	private WebElement protitle;
	
	@FindBy(id="add_blog_blog_subtitle")
	private WebElement prosubtitle;
	
	@FindBy(xpath="//button[@id='add_blog_submit']")
	private WebElement saveblogbutton;
	
	@FindBy(xpath="//div[contains(text(),'The project has been added.')]")
	private WebElement successmsg;
	
	@FindBy(xpath="//table[@class='data_table table']/tbody/tr[2]/td[1]/a")
	private WebElement clickprojectlink;
	
	@FindBy(xpath="//a[contains(text(),'Welcome !')]")
	private WebElement welcomemsg;
	
	@FindBy(xpath="//img[@title='New task']")
	private WebElement newtaskicon;
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement newtasktitle;
	
	@FindBy(xpath="//button[@id='add_post_save']")
	private WebElement newtasksave;
	
	@FindBy(xpath="//img[@title='Roles management']")
	private WebElement rolemgmticon;
	
	@FindBy(xpath="//img[@title='Add a new role']")
	private WebElement newroleicon;
	
	@FindBy(xpath="//input[@name='task_name']")
	private WebElement roletasktext;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	private WebElement rolesavebutton;
	
	@FindBy(xpath="//img[@title='Assign roles']")
	private WebElement assignroleicon;
	
	@FindBy(xpath="//button[@id='assign_task_submit']")
	private WebElement validatebutton;
	
	@FindBy(xpath="//button[@data-id='assign_task_task_user_id']/span[1]")
	private WebElement userrole;
	
	@FindBy(xpath="//button[@data-id='assign_task_task_task_id']/span[1]")
	private WebElement usertask;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertmsg;
	
	@FindBy(xpath="//img[@title='Users management']")
	private WebElement usermgmticon;
	
	@FindBy(xpath="//input[@name='user[]']")
	private WebElement usercheckbox;
	
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
	
	@FindBy(xpath="//a[contains(text(),'Reporting')]")
	private WebElement reporttab;
	
	@FindBy(xpath="//a[contains(text(),'Followed students')]")
	private WebElement followstudentslink;
	
	@FindBy(xpath="//input[@id='search_user_keyword']")
	private WebElement searchkeyword;
	
	@FindBy(xpath="//button[@id='search_user_submit']")
	private WebElement reportsearchbutton;
	
	@FindBy(xpath="//*[@class='data_table table']/tbody/tr[3]/td[5]/a[2]/img")
	private WebElement clickarrow;
	
	
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
	
	public void ClickHomePage()
	{
		this.homepagelink.click();
	}
	
	public void ClickCreateCourseLink()
	{
		this.createcourselink.click();
	}
	
	public void EnterCourseNameTextbox(String value)
	{
		this.coursename.clear();
		this.coursename.sendKeys(value);
	}
	
	public void ClickAdvancedSettingsLink()
	{
		this.advancedsettingslink.click();
	}
	
	public void SelectCategoryFromDD(String category)
	{
		this.categorydd.click();
		this.categorytextbox.clear();
		this.categorytextbox.sendKeys(category);
		Actions action = new Actions(driver);		
		action.click(categoryselected).sendKeys(Keys.TAB).build().perform();		
	}
	
	public void EnterCourseRequested(String value)
	{
		this.courserequested.clear();
		this.courserequested.sendKeys(value);
	}
	
	public void SelectLanguageFromDD(String lang)
	{
		this.langdd.click();
		this.langtextbox.clear();
		this.langtextbox.sendKeys(lang);
		Actions action = new Actions(driver);		
		action.click(langselected).sendKeys(Keys.TAB).build().perform();		
	}
	
	public void ClickAddCourseButton()
	{
		this.addcoursebutton.click();
	}
	
	public void ClickAddIconButton()
	{
		this.addiconbutton.click();
	}
	
	public void EnterIntroductionText(String value) throws InterruptedException
	{
		WebElement frame = this.msgframe;
		WebDriver frame1 = driver.switchTo().frame(frame);		
		Thread.sleep(3000);
		WebElement element = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(element).perform();
        this.msgbody.sendKeys(value);		
        
	}
	
	public void ClickSaveIntroTextButton()
	{
		driver.switchTo().defaultContent();
		this.saveintrotextbutton.click();
	}
	
	public void ClickCourseDescIcon()
	{
		this.coursedescicon.click();
	}
	
	public void ClickDescIcon()
	{
		this.descicon.click();
	}
	
	public void EnterTitleAndDescTextbox(String titlevalue, String descvalue) throws InterruptedException
	{
		this.desctitle.clear();
		this.desctitle.sendKeys(titlevalue);
		WebElement frame = this.desctitleframe;
		WebDriver frame1 = driver.switchTo().frame(frame);
		Thread.sleep(3000);
		WebElement element = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(element).perform();
		this.descmsgbody.sendKeys(descvalue);	
	}
	
	public void ClickDescSaveButton()
	{
		driver.switchTo().defaultContent();
		this.descsavebutton.click();
	}
	
	public void ClickObjectiveIcon()
	{
		this.objectivesicon.click();
	}
	
	public void EnterObjectivesTextbox(String titlevalue, String descvalue) throws InterruptedException
	{
		this.objtitle.clear();
		this.objtitle.sendKeys(titlevalue);
		WebElement frame = this.objtitleframe;
		WebDriver frame1 = driver.switchTo().frame(frame);
		Thread.sleep(3000);
		WebElement element = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(element).perform();
		this.objmsgbody.sendKeys(descvalue);
	}
	
	public void ClickObjSaveButton()
	{
		driver.switchTo().defaultContent();
		this.descsavebutton.click();
	}
	
	public void ClickTopicsIcon()
	{
		this.topicicon.click();
	}
	
	public void EnterTopicsTextbox(String titlevalue, String descvalue) throws InterruptedException
	{
		this.topictitle.clear();
		this.topictitle.sendKeys(titlevalue);
		WebElement frame = this.topictitleframe;
		WebDriver frame1 = driver.switchTo().frame(frame);
		Thread.sleep(3000);
		WebElement element = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(element).perform();
		this.topicmsgbody.sendKeys(descvalue);
	}
	
	public void ClickTopicSaveButton()
	{
		driver.switchTo().defaultContent();
		this.topicsavebutton.click();
	}
	
	public void ClickMyCoursesLink()
	{
		this.mycourseslink.click();
	}
	
	public void ClickMyAddedCourseLink()
	{
		this.myaddedcourselink.click();
	}
	
	public void ClickProjectIcon()
	{
		this.projecticon.click();
	}
	
	public void ClickNewProjectIcon()
	{
		this.newprojecticon.click();
	}
	
	public void EnterTitleAndsubTitle(String title, String subtitle)
	{
		this.protitle.clear();
		this.protitle.sendKeys(title);
		this.prosubtitle.clear();
		this.prosubtitle.sendKeys(subtitle);
		this.saveblogbutton.click();
	}
	
	public boolean SuccessMsg()
	{
		if(this.successmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	public void ClickAddedProjectLink()
	{
		this.clickprojectlink.click();
	}
	
	public String getWelcomeMsg()
	{
		String text = this.welcomemsg.getText();
		return text;		
	}
	
	public void ClickNewTaskIcon()
	{
		this.newtaskicon.click();
	}
	
	public void EnterNewTaskTextbox(String title)
	{
		this.newtasktitle.clear();
		this.newtasktitle.sendKeys(title);
		this.newtasksave.click();		
	}
	
	public void ClickRoleMgmtAndNewRole()
	{
		this.rolemgmticon.click();
		this.newroleicon.click();
	}
	
	public void EnterNewRoleTextBox(String value)
	{
		this.roletasktext.clear();
		this.roletasktext.sendKeys(value);
		this.rolesavebutton.click();
	}
	
	public void ClickAssignRoleIcon()
	{
		this.assignroleicon.click();
	}
	
	public void ClickValidateButton()
	{
		this.validatebutton.click();
	}
	
	public boolean UserRoleIsDisplayed()
	{
		
		if(this.userrole.isDisplayed())
		{
		return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean TaskIsDisplayed()
	{
		
		if(this.usertask.isDisplayed())
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean GetSuccessMsg()
	{
		if(this.successmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickUserMgmt()
	{
		this.usermgmticon.click();
	}
	
	public void ClickUserCheckbox()
	{
		this.usercheckbox.click();
	}
	
	public boolean UserCheckboxIsSelected()
	{
		if(this.usercheckbox.isSelected())
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
	
	public void ClickReportTab()
	{
		this.reporttab.click();
	}
	
	public void ClickFollowingStudentsLink()
	{
		this.followstudentslink.click();
	}
	
	public void EnterKeyWordTextbox(String value)
	{
		this.searchkeyword.clear();
		this.searchkeyword.sendKeys(value);
		this.reportsearchbutton.click();
	}
	
	public void ClickArrowIcon()
	{
		this.clickarrow.click();
	}
	
	
	
	

}
