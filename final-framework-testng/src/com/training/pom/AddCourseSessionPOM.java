/**
 * The main objective of this POM is to add Courses and Session for the E-learning Application
 */
package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sundararajan R
 *
 */
public class AddCourseSessionPOM {
private WebDriver driver; 
	
	public AddCourseSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createcourse;
	
	@FindBy(id="update_course_title")
	private WebElement coursetitle;
	
	@FindBy(id="visual_code")
	private WebElement codetext;
	
	@FindBy(xpath="//div[@class='btn-group bootstrap-select show-tick form-control']")
	private WebElement clickteachers;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/div/div/input")
	private WebElement teachers;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/div/ul/li[@class='selected']/a/span[@class='glyphicon glyphicon-ok check-mark']")
	private WebElement unchecktick;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/div/ul/li[3]/a")
	private WebElement typedoption;
	
	@FindBy(xpath="//button[@data-id='update_course_category_code']")
	private WebElement category;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[4]//input")
	private WebElement categorytext;
	
	@FindBy(xpath = "//*[@id=\"update_course\"]/fieldset/div[4]//li[4]/a")
	private WebElement catergoryOpted;
	
	@FindBy(xpath="//button[@data-id='update_course_course_language']")
	private WebElement language;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[7]//div//ul/li[6]/a/span[1]")
	private WebElement langSelect;
	
	@FindBy(id="update_course_submit")
	private WebElement createcoursebutton;
		
	@FindBy(xpath="//li[@class='admin active']/a")
	private WebElement clickadminlink;
	
	@FindBy(xpath="//a[contains(text(),'Add a training session')]")
	private WebElement clickaddtraininglink;
	
	@FindBy(id="add_session_name")
	private WebElement addsessionname;
	
	@FindBy(id="add_session_submit")
	private WebElement addsessionbutton;
	
	@FindBy(id="origin")
	private WebElement selectusers;
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement FwdButton;
	
	@FindBy(xpath="//button[contains(text(),'Next step')]")
	private WebElement clicknextstep;
	
	@FindBy(id="user_to_add")
	private WebElement adduser;
	
	@FindBy(xpath="//div[@id='ajax_list_users_single']/a[contains(text(),\"R Sundar (Sundarashok)\")]")
	private WebElement username;
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement clickfinishsession;
	
	public void ClickCreateCourse()
	{
		this.createcourse.click();
	}
	
	public void EnterCourseTitle(String name)
	{
		this.coursetitle.sendKeys(name);		
	}
	
	public boolean GetCourseTitle()
	{
		if(coursetitle.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	public void EnterCodeText(String name)
	{
		this.codetext.sendKeys(name);		
	}	
	
	public void SelectTeachers(String name) 
	{
		this.clickteachers.click();	
		this.unchecktick.click();
		this.teachers.sendKeys(name);	
		Actions action = new Actions(driver);		
		action.click(typedoption).sendKeys(Keys.TAB).build().perform();				
	}
	
	public void SelectCategory(String name)
	{
		this.category.click();
		this.categorytext.sendKeys(name);
		Actions action = new Actions(driver);		
		action.click(catergoryOpted).build().perform();		
	}
	
	public void SelectLanguage(String name)
	{
		this.language.click();
		this.langSelect.click();		
	}
	
	public void ClickCreateCourseButton()
	{
		this.createcoursebutton.click();
	}
	
	public void ClickAdminLink()
	{
		this.clickadminlink.click();
	}
	
	public void ClickAddTrainingLink()
	{
		this.clickaddtraininglink.click();
	}
	
	public void EnterSessionName(String name)
	{
		this.addsessionname.sendKeys(name);
	}
	
	public boolean GetSessionName()
	{
		if(this.addsessionname.isDisplayed())
				{
					return true;
				}
		else
		{
			return false;
		}
	}
	
	public void ClickAddSession()
	{
		this.addsessionbutton.click();
	}
	
	public void SelectUsers()
	{
		Select selectuser = new Select(this.selectusers);
		List <WebElement> seloption = selectuser.getOptions();
		Actions action = new Actions(driver);
		action.click(seloption.get(1)).build().perform();	
	}
	
	public void ClickForwardButton()
	{
		this.FwdButton.click();
	}
	
	public void ClickNextStepButton()
	{
		this.clicknextstep.click();
	}
	
	public void SelectUserFromList(String adduser)
	{
		this.adduser.sendKeys(adduser);
		this.adduser.sendKeys(Keys.TAB);
		this.username.click();
	}
	
	public void ClickFinishSession()
	{
		this.clickfinishsession.click();
	}	
	

}
