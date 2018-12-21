package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SuscribePOM {
	
private WebDriver driver; 
	
	public SuscribePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='usergroups']/tbody/tr[2]/td/a[1]/img")
	private WebElement AddSuscribe;
	
	@FindBy(xpath ="//form[@name='formulaire']/legend")
	private String Text;
	
	@FindBy(id="elements_not_in")
	private WebElement users;
	
	@FindBy(xpath = "//em[@class='fa fa-arrow-right']")
	private WebElement fwdbutton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement suscribebutton;
	
	@FindBy(xpath ="//table[@id='usergroups']/tbody/tr[2]/td[2]")
	private WebElement ViewRowValue;
	
	
	public void ClickAddSuscribe()
	{
		this.AddSuscribe.click();
	}
	
	public boolean TextDisplay()
	{
		String ExpText = "Subscribe users to class: Demo";
		if (this.Text.equals(ExpText))
		{
		return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public void SelMultipleUsers() throws InterruptedException
	{
		Select sel = new Select(this.users);
		List <WebElement> userslist = sel.getOptions();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(userslist.get(2)).click(userslist.get(5)).build().perform();
		Thread.sleep(4000);
	}
	
	public void ClickSuscribeButton() throws InterruptedException
	{
		this.fwdbutton.click();
		Thread.sleep(2000);
		this.suscribebutton.click();
		
	}
	
	public String UsersSuscribed()
	{
		String uservalue = this.ViewRowValue.getText();
		return uservalue;
		
	}

}
