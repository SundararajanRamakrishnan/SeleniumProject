package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Rashmita {
	
	

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;

		
		@Test
		public void validLoginTest() {
			
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\Desktop\\SeleniumTool\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://elearning.hommelle.com/index.php");
		driver.findElement(By.id("login")).sendKeys("manzoor");
		driver.findElement(By.id("password")).sendKeys("mehadi");
		driver.findElement(By.id("formLogin_submitAuth")).click();
		driver.findElement(By.xpath("//h4[@class='course-items-title']/a[1]")).click();
		driver.findElement(By.xpath("//img[@id='toolimage_1944']")).click();
		driver.findElement(By.xpath("//table[@class=\"data_table table\"]/tbody/tr[2]/td[1]/a[contains(text(),\"Group 0001\")]")).click();
		
		}

}
