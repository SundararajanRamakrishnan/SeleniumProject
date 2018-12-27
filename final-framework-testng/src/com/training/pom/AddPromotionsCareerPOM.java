/**
 * The main objective of this POM is to add Careers and Promotions for the E-learning Application
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
public class AddPromotionsCareerPOM {
private WebDriver driver; 
	
	public AddPromotionsCareerPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li/a[contains(text(),'Careers and promotions')]")
	private WebElement careerpromotionlink;
	
	@FindBy(xpath="//img[@title='Careers']")
	private WebElement careersicon;
	
	@FindBy(xpath="//img[@title='Add']")
	private WebElement addicon;
	
	@FindBy(id="career_name")
	private WebElement addcareerName;
	
	@FindBy(id="career_submit")
	private WebElement careeraddbutton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg;
	
	@FindBy(xpath="//li[@class='admin active']/a")
	private WebElement clickAdminLink;
	
	@FindBy(xpath="//img[@title='Promotions']")
	private WebElement promotionsicon;
	
	@FindBy(xpath="//img[@title='Add']")
	private WebElement addpromotionicon;
	
	@FindBy(id="name")
	private WebElement addpromotionName;
	
	@FindBy(id="promotion_submit")
	private WebElement promotionaddbutton;
	
	@FindBy(xpath="//img[@title='Add a training session']")
	private WebElement addtrainingicon;
	
	@FindBy(id="add_session_name")
	private WebElement sessionName;
	
	@FindBy(id="add_session_submit")
	private WebElement sessionaddbutton;
	
	@FindBy(id="origin")
	private WebElement selectcourses;
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement FwdButton;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement nextstep;
	
	@FindBy(id="user_to_add")
	private WebElement adduser;
	
	@FindBy(xpath="//div[@id='ajax_list_users_single']/a[contains(text(),\"R Sundar (Sundarashok)\")]")
	private WebElement username;
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement clickFinish;
	
	public void ClickCareerPromotionLink()
	{
		this.careerpromotionlink.click();
	}
	
	public void ClickCareerIcon()
	{
		this.careersicon.click();
	}
	
	public void ClickAddIcon()
	{
		this.addicon.click();
	}
	
	public void EnterNameInCareerTextbox(String name)
	{
		this.addcareerName.sendKeys(name);
	}
	
	public void ClickCareerAddButton()
	{
		this.careeraddbutton.click();
	}
	
	public void GetMessageText()
	{
		//this.successmsg.getText();
		System.out.println(this.successmsg.getText());
	}
	
	public boolean GetMessage()
	{
		if (this.successmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickAdminTab()
	{
		this.clickAdminLink.click();
	}
	
	public void ClickPromotionsIcon()
	{
		this.promotionsicon.click();
	}
	
	public void AddPromotionsIcon()
	{
		this.addpromotionicon.click();
	}
	
	public void EnterNameInPromotionTextbox(String name)
	{
		this.addpromotionName.sendKeys(name);
	}
	
	public void ClickPromotionAddButton()
	{
		this.promotionaddbutton.click();
	}
	
	public void AddTrainingIcon()
	{
		this.addtrainingicon.click();
	}
	
	public void EnterSessionNameInTextbox(String name)
	{
		this.sessionName.sendKeys(name);
	}
	
	public void ClickSessionAddButton()
	{
		this.sessionaddbutton.click();
	}
	
	public void SelectCourses()
	{
		Select selectcourse = new Select(this.selectcourses);
		List <WebElement> seloption = selectcourse.getOptions();
		Actions action = new Actions(driver);
		action.click(seloption.get(1)).click(seloption.get(2)).build().perform();	
	}
	
	public void ClickForwardButton()
	{
		this.FwdButton.click();
	}
	
	public void ClickNextStepButton()
	{
		this.nextstep.click();
	}
	
	public void SelectUserFromList(String adduser)
	{
		this.adduser.sendKeys(adduser);
		this.adduser.sendKeys(Keys.TAB);
		this.username.click();
	}
	
	public void ClickFinishSessionCreation()
	{
		this.clickFinish.click();
	}

}
