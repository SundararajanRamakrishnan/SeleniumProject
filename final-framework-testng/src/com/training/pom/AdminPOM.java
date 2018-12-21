package com.training.pom;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPOM {
	
private WebDriver driver; 
	
	public AdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='admin active']")
	private WebElement Admin_Tab;
	
	@FindBy(xpath="//ul[@class='list-items-admin']/li[7]/a[contains(text(),'Classes')]")
	private WebElement Class_Link;
	
	@FindBy(xpath="//div[@class='actions']/a[2]/img")
	private WebElement Add_Class;
	
	@FindBy(id="usergroup_name")
	private WebElement Course_Name;
	
	@FindBy(id="usergroup_description")
	private WebElement Course_Desc;
	
	
	@FindBy(id="usergroup_name")
	private String CourseName;
	
	@FindBy(id="usergroup_description")
	private String CourseDesc;
	
	@FindBy(xpath="//select[@id='usergroup_visibility']/option")
	private List <WebElement> Select_Options;
		
	@FindBy(xpath = "//span[@class='filter-option pull-left']")
	private WebElement DD_Select;
		
	@FindBy(id="usergroup_submit")
	private WebElement Add_Button;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement Add_Msg;
	
	@FindBy(xpath ="//table[@id='usergroups']")
	private WebElement View_Row;
		
	//Writing the methods to be called in the Test
	public void ClickAdminLink()
	{
		this.Admin_Tab.click();
	}
	
	public void AddClassLink()
	{
		this.Class_Link.click();
	}
	
	public void AddClassNameIcon()
	{
		this.Add_Class.click();
	}
	
	public void EnterTextInCourseName(String CName)
	{
		this.Course_Name.clear();
		this.Course_Name.sendKeys(CName);
	}
	
	public String GetTextFromCourseName()
	{
		String CName;
		return CName =  this.Course_Name.getAttribute("value");		
		
	}
	
	public void EnterTextInCourseDesc(String CDesc)
	{
		this.Course_Desc.clear();
		this.Course_Desc.sendKeys(CDesc);
	}
	
	public String GetTextFromCourseDesc()
	{
		String CDesc = this.Course_Name.getAttribute("value");
		return CDesc;
	}
		
	public void SelectGroupPermissions() throws InterruptedException
	{
		Thread.sleep(6000);			
		this.DD_Select.click();
		Thread.sleep(6000);
		this.Select_Options.get(0).click();	
	}
	
	public boolean SelValueIsDisplayed()
	{
		
		if (this.Select_Options.get(0).isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public void ClickAddButton()
	{
		this.Add_Button.click();
	}
	
	public boolean VerifyClassName()
	{
		if (this.Course_Name.isDisplayed())
		{
			return true;
		}
		
		else
		{
		return false;
		}
	}
	
	public boolean VerifyClassDesc()
	{
		if (this.Course_Desc.isDisplayed())
		{
			return true;
		}
		
		else
		{
		return false;
		}
	}
	
	public boolean AddMessage()
	{
		if (this.Add_Msg.isDisplayed())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public boolean ViewTable()
	{
		if (this.View_Row.isDisplayed())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
}
