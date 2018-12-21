package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoursePOM {
	private WebDriver driver;
	
	public CoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='usergroups']/tbody/tr[2]/td/a[2]/img")
	private WebElement AddCourse;
	
	@FindBy(xpath="//select[@id='elements_not_in']")
	private WebElement SelCourses;
	
	@FindBy(xpath = "//em[@class='fa fa-arrow-right']")
	private WebElement fwdbutton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement suscribebutton;
	
	@FindBy(xpath ="//table[@id='usergroups']/tbody/tr[2]/td[3]")
	private WebElement ViewRowValue;
	
	
	public void ClickAddCourse()
	{
		this.AddCourse.click();
	}
	
	public void SelectCourses()
	{
		Select sel = new Select(this.SelCourses);
		List <WebElement> courselist = sel.getOptions();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(courselist.get(0)).build().perform();
		
	}
	
	public void ClickSuscribeCourseButton() throws InterruptedException
	{
		this.fwdbutton.click();
		Thread.sleep(2000);
		this.suscribebutton.click();
		
	}
	
	public boolean CoursesSuscribed()
	{
	
		if (this.ViewRowValue.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

}
