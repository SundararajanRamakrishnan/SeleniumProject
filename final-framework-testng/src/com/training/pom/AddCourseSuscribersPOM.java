/**
 * The main objective of this POM is to add Courses and Subscribers for the E-learning Application
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
public class AddCourseSuscribersPOM {
private WebDriver driver; 
	
	public AddCourseSuscribersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='list-items-admin']/li/a[contains(text(),\"Sessions categories list\")]")
	private WebElement sessioncatlist;
	
	@FindBy(xpath="//img[@title=\"Training sessions list\"]")
	private WebElement traininglist;
	
	@FindBy(xpath="//table[@id='sessions']/tbody/tr[@id='6']")
	private WebElement courselist; 
	
	@FindBy(xpath="//table[@id='sessions']/tbody/tr[@id='6']/td[6]//img[@title='Subscribe users to this session']")
	private WebElement suscribericon;
			
	@FindBy(id="user_to_add")
	private WebElement adduser;
	
	@FindBy(xpath="//div[@id='ajax_list_users_single']/a[contains(text(),\"R Sundar (Sundarashok)\")]")
	private WebElement username;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe users to this session')]")
	private WebElement clicksuscribersession;
	
	@FindBy(id="destination_users")
	private WebElement destinationusers;
	
	@FindBy(xpath="//h3[contains(text(),' IBM_Demo')]")
	private WebElement pagetext;
	
	@FindBy(xpath="//li[@class='admin active']/a")
	private WebElement clickAdminLink;
	
	@FindBy(xpath="//table[@id='sessions']/tbody/tr[@id='6']/td[6]//img[@title='Add courses to this session']")
	private WebElement courseicon;
	
	@FindBy(xpath="//legend[contains(text(),'Add courses to this session (IBM_Demo)')]")
	private WebElement Titletext;
	
	@FindBy(id="origin")
	private WebElement selectusers;
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement FwdButton;
	
	@FindBy(xpath="//button[contains(text(),'Add courses to this session')]")
	private WebElement clickAddCoursesbutton;
	
	public void ClickSessionCategoryList()
	{
		this.sessioncatlist.click();
	}
	
	public void ClickTrainingList()
	{
		this.traininglist.click();
	}
	
	public void ClickSuscribersList()
	{
	this.suscribericon.click();	
	}
			
	public void SelectUserFromList(String adduser)
	{
		this.adduser.sendKeys(adduser);
		this.adduser.sendKeys(Keys.TAB);
		this.username.click();
	}
		
	public boolean UsersIsDisplayed()
	{
		Select userlist = new Select(this.destinationusers);
		List<WebElement> username = userlist.getOptions();
		
		if(!username.isEmpty())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void ClickSuscribersSession()
	{
		this.clicksuscribersession.click();
	}
	
	public void GetPageTitle()
	{		
		this.pagetext.getText();
		System.out.println(this.pagetext.getText());
	}
	
	public void ClickAddCourse()
	{
		this.clickAdminLink.click();
		this.sessioncatlist.click();
		this.traininglist.click();
		this.courseicon.click();
	}
	
	public void GetPageTitleText()
	{
		this.Titletext.getText();
		System.out.println(this.Titletext.getText());		
	}
	
	public void SelectUsers()
	{
		Select selectuser = new Select(this.selectusers);
		List <WebElement> seloption = selectuser.getOptions();
		Actions action = new Actions(driver);
		action.click(seloption.get(1)).click(seloption.get(2)).build().perform();	
	}
	
	public void ClickForwardButton()
	{
		this.FwdButton.click();
	}
	
	public void ClickAddCoursesButton()
	{
		this.clickAddCoursesbutton.click();
	}

}
