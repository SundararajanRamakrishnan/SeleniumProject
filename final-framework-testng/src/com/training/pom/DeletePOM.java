package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePOM {
	
private WebDriver driver; 
	
	public DeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='usergroups']/tbody/tr[2]/td/a[5]/img")
	private WebElement DeleteItem;
		
	public void ClickDeleteButton()
	{
		this.DeleteItem.click();
	}
	
	public void AlertPopUp()
	{
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();		
	}
}
