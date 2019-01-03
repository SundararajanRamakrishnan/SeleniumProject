	package com.training.sanity.tests;

	import java.io.FileInputStream;

	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import com.training.generics.ScreenShot;
	import com.training.pom.RTTC_046_Remove_add_order;
	import com.training.pom.LoginPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;
	public class TC46 {
	    private WebDriver driver;
	    private String baseUrl;
	    private LoginPOM loginPOM;
	    private static Properties properties;
	    private ScreenShot screenShot;
	    private RTTC_046_Remove_add_order dashboard;

	    @BeforeClass
	    public static void setUpBeforeClass() throws IOException {
	        properties = new Properties();
	        FileInputStream inStream = new FileInputStream("./resources/others.properties");
	        properties.load(inStream);
	    }
	    @BeforeMethod
	    public void setUp() throws Exception {
	        driver = DriverFactory.getDriver(DriverNames.CHROME);
	        loginPOM = new LoginPOM(driver);
	        //baseUrl = properties.getProperty("baseURL");
	        screenShot = new ScreenShot(driver);
	        dashboard = new RTTC_046_Remove_add_order(driver);
	        // open the browser
	       // driver.get(baseUrl);
	        driver.get("http://retail.hommelle.com/admin");
	    }
	    
	    @AfterMethod
	    public void tearDown() throws Exception {
	        Thread.sleep(1000);
	        driver.quit();
	    }
	    @Test
	    public void validLoginTest() throws InterruptedException {
	        loginPOM.SendUserName("admin");
	        loginPOM.SendPassword("admin@123");        
	        loginPOM.ClickLoginBtn();
	        Thread.sleep(100);
	        dashboard.mouseonsalesicon();
	        dashboard.clickonorderslink();
	        dashboard.clickoneditbutton();
	        Thread.sleep(3000);
	        System.out.println("Click on Continue Button");
	        dashboard.ContinueClickButton();
	        System.out.println("Success");
	      //  driver.navigate().forward();
	      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        dashboard.clickonremoveicon();
	        dashboard.sendproductname("Lorem ipsum dolor sit amet");
	     //   Thread.sleep(1000);
	        dashboard.sendQuantity("1");
	    //    Thread.sleep(1000);
	        dashboard.clickonaddproduct();
	     //   Thread.sleep(5000);
	          dashboard.clickcontinue();
	     //   Thread.sleep(1000);
	              dashboard.clickcontinueonpaymentpage();
	    //    Thread.sleep(1000);
	        dashboard.clickoncontinueshipping();
	    //    Thread.sleep(1000);
	        dashboard.clickonsave();
	      //  Thread.sleep(1000);
	    }   
	    
	    }



