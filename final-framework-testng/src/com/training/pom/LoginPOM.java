package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(id="input-username")
	private WebElement userName1; 
	
	@FindBy(id="input-password")
	private WebElement password1;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginButton;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void SendUserName(String userName) {
		this.userName1.clear();
		this.userName1.sendKeys(userName);
	}
	
	public void SendPassword(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void ClickLoginBtn() {
		this.loginButton.click(); 
	}
}
