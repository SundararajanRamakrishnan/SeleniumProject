package com.training.regression.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\Desktop\\SeleniumTool\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login");
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
		driver.findElement(By.xpath("//table[@class='nested']/tbody/tr[3]/td/input")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("poongodi");
		driver.findElement(By.id("memberUsername")).sendKeys(Keys.ENTER);	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"newButton\"]")).click();
		Thread.sleep(2000);
		/*
		WebElement frame1 = driver.findElement(By.xpath("//td[@id='cke_contents_descriptionText']//iframe"));
        WebDriver frame = driver.switchTo().frame(frame1);
        Thread.sleep(3000);
        WebElement el  =  driver.switchTo().activeElement();
        new Actions(driver).moveToElement(el).perform();
        driver.findElement(By.xpath("/html/body")).sendKeys("Check");	
        */
        driver.findElement(By.xpath("//iframe[contains(@title,'Rich text editor')]")).sendKeys("New Offer");
	}

}
