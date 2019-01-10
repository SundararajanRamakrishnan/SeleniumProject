/**
 * The objective of this POM Class is to locate the elements for Users SignUp
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
public class SignUpExcelPOM {
	
private WebDriver driver; 
	
	public SignUpExcelPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	private WebElement signup;
	
	@FindBy(id="registration_firstname")
	private WebElement firstname;
	
	@FindBy(id="registration_lastname")
	private WebElement lastname;
	
	@FindBy(id="registration_email")
	private WebElement email;
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="pass1")
	private WebElement password;
	
	@FindBy(id="pass2")
	private WebElement confirmpassword;
	
	@FindBy(id="registration_phone")
	private WebElement phone;
	
	@FindBy(xpath="//button[@data-id='registration_language']")
	private WebElement langdd;
	
	@FindBy(xpath="//div[@class='bs-searchbox']/input[@class='form-control']")
	private WebElement langtextbox;
	
	@FindBy(xpath="//ul[@class='dropdown-menu inner']/li[@class='selected active']/a/span[contains(text(),'English')]")
	private WebElement langselected;
	
	@FindBy(xpath ="//input[@name='status' and @value='5']")
	private WebElement Studentradiobtn;
	
	@FindBy(id="registration_submit")
	private WebElement RegisterButton;
	
	@FindBy(xpath = "//li[@class='dropdown avatar-user']/a/img")
	private WebElement ClickUser;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[5]/a")
	private WebElement DDOptionLogout;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']")
	private WebElement successmsg;
	
		
	public void ClickSignUpLink()
	{
		this.signup.click();
	}
	
	public void EnterFirstNameTextBox(String firstName)
	{
		this.firstname.clear();
		this.firstname.sendKeys(firstName);
	}
	
	public void EnterLastNameTextBox(String lastName)
	{
		this.lastname.clear();
		this.lastname.sendKeys(lastName);
	}
	
	public void EnterEmailTextBox(String email)
	{
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void EnterUserNameTextBox(String username)
	{
		this.userName.clear();
		this.userName.sendKeys(username);
	}
	
	public void EnterPasswordTextBox(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void EnterConfirmPasswordTextBox(String Cpassword)
	{
		this.confirmpassword.clear();
		this.confirmpassword.sendKeys(Cpassword);
	}
	
	public void EnterPhoneTextBox(String phone)
	{
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void SelectLanguageFromDD(String lang)
	{
		this.langdd.click();
		this.langtextbox.clear();
		this.langtextbox.sendKeys(lang);
		Actions action = new Actions(driver);		
		action.click(langselected).sendKeys(Keys.TAB).build().perform();		
	}
	
	public void ProfileRadioButton()
	{
		this.Studentradiobtn.click();
	}
	
	public boolean StudentRadioButtonIsSelected()
	{
		if (this.Studentradiobtn.isSelected())
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public void ClickRegistrationButton()
	{
		this.RegisterButton.click();
	}
	
	public boolean GetSuccessMessage()
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
	
	
	
	public void ClickLogOutButton()
	{
		this.ClickUser.click();
		this.DDOptionLogout.click();
	}
	
	
}
