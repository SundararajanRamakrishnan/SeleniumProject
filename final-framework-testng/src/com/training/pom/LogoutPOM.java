package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM {

	private WebDriver driver;
	public LogoutPOM(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='dropdown avatar-user']/a/img")
	private WebElement ClickUser;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[3]/a")
	private WebElement DDOptionInbox;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[4]/a")
	private WebElement DDOptionCertificate;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[5]/a")
	private WebElement DDOptionLogout;
	
	@FindBy(xpath="//div[@class='logo']")
	private WebElement LogoText;
	
	public void ClickUserIcon()
	{
		this.ClickUser.click();
	}
	
	public boolean GetDDOptionsInbox()
	{
		
		if (this.DDOptionInbox.isDisplayed())
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}
	
	public boolean GetDDOptionsCertificate()
	{
		
		if (this.DDOptionCertificate.isEnabled())
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}
	
	public boolean GetDDOptionsLogout()
	{
		
		if (this.DDOptionLogout.isEnabled())
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}
	
	public void ClickDDOptionsLogout()
	{
		this.DDOptionLogout.click();
	}
	
	
}
