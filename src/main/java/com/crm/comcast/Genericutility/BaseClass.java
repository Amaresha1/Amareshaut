package com.crm.comcast.Genericutility;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains common configuration annotations of Testng&which is used for common operation
 * @author acer
 *
 */
public class BaseClass 
{
   public Fileutility flib=new Fileutility();
   public Dbutility dlib=new Dbutility();
   public Excelutility elib=new Excelutility();
   public Javautility jlib=new Javautility();
   WebDriverUtility wlib=new WebDriverUtility();
   public WebDriver driver;
   public static WebDriver sdriver;
   @BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	/*
	 * public void bsconfig() throws Throwable { dlib.connecttoDatabase();
	 * System.out.println("-----Connected to DB----"); }
	 */
   //@Parameters("BROWSER")
   @org.testng.annotations.BeforeClass(groups= {"SmokeTest","RegressionTest"})
   public void bcconfig() throws Throwable
   {
	  //Read data from property file
	   String BROWSER = flib.getpropertykeyvalue("browser");
	   String URL = flib.getpropertykeyvalue("url");
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }else if(BROWSER.equalsIgnoreCase("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }else
	   {
		   System.out.println("Browser launched Successfully");
	   }
	   wlib.waituntilelementvisibilityDom(driver);
	   sdriver=driver;
	   driver.get(URL);
   }
 
   @BeforeMethod(groups= {"SmokeTest","RegressionTest"})
   public void bmconfig() throws Throwable
   {
	   //Read data from property file
	   String USERNAME = flib.getpropertykeyvalue("username");
	   String PASSWORD = flib.getpropertykeyvalue("pass");
	   //Login to app  
	   Login lp=new Login(driver);
	   lp.Loginapp(USERNAME, PASSWORD);
	   System.out.println("======Login  Successfully=====");
 
   }
   
   @AfterMethod(groups= {"SmokeTest","RegressionTest"})
   public void amconfig()
   {
	   //logout application
	   Homepage hp=new Homepage(driver);
	   hp.logout();
	   System.out.println("====Loggged out App Successfully=====");

   }
   @AfterClass(groups= {"SmokeTest","RegressionTest"})
   public void acconfig() 
   {
	//close the browser
	   driver.close();
	   System.out.println("Browser closed Successfully");

   }
   
	/*
	 * @AfterSuite public void asconfig() throws Throwable { // Close the DB
	 * connection dlib.closeDatabase();
	 * System.out.println("Database closed Successfully");
	 * 
	 * }
	 */
}
