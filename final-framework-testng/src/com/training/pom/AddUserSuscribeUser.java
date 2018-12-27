/**
 * The main objective of this POM is to add Users and Subscribers for the E-learning Application
 */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sundararajan R
 *
 */
public class AddUserSuscribeUser {

private WebDriver driver;
	
	public AddUserSuscribeUser(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement adduser;
	
	@FindBy(id="firstname")
	private WebElement firstname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="username")
	private WebElement loginid;
	
	@FindBy(xpath="//input[@name='password[password_auto]' and @value='0']")
	private WebElement manualpwdselect;
	
	@FindBy(id="password")
	private WebElement loginpwd;
	
	@FindBy(xpath="//button[@class='btn dropdown-toggle btn-default' and @data-id ='status_select']")
	private WebElement clickprofiledd;
	
	@FindBy(id="status_select")
	private WebElement selectoptions;
	
	@FindBy(xpath="//select[@id='status_select']/option")
	private List<WebElement> profileoptions;
		
	@FindBy(name="submit")
	private WebElement addbutton;
	
	@FindBy(xpath="//li[@class='admin active']/a")
	private WebElement clickadminlink;
	
	
	public void ClickAddUser()
	{
		this.adduser.click();
	}
	
	public void EnterFirstNameInTextBox(String name)
	{
		this.firstname.clear();
		this.firstname.sendKeys(name);
	}
	
	public void EnterLastNameInTextBox(String name)
	{
		this.lastname.clear();
		this.lastname.sendKeys(name);
	}
	
	
	public void EnterEmailInTextBox(String name)
	{
		this.email.clear();
		this.email.sendKeys(name);
	}
	
	public void EnterPhoneInTextBox(String name)
	{
		this.phone.clear();
		this.phone.sendKeys(name);
	}
	
	public void EnterLoginIdInTextBox(String name)
	{
		this.loginid.clear();
		this.loginid.sendKeys(name);
	}
	
	
	public void SelectManualRadioButton()
	{
		this.manualpwdselect.click();
	}
	
	public boolean ManualRadioBtnIsSelected()
	{
		if (this.manualpwdselect.isSelected())
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void ClickProfileDropDown()
	{
		this.clickprofiledd.click();
	}
	
	public void SelectProfileOptions()
	{
		this.profileoptions.get(2).click();	
		
	}
	
	public void scrolldownpage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,500)","");
		
		//js.executeScript("arguments[0].scrollIntoView();", clickprofiledd);
		
	}
	
	public void ClickAddButton()
	{
		this.addbutton.click();
	}

	public void ClickAdminLink()
	{
		this.clickadminlink.click();
	}
	
}
