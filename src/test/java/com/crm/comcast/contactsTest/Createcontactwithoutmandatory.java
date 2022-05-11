package com.crm.comcast.contactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.Genericutility.Excelutility;
import com.crm.comcast.Genericutility.Fileutility;
import com.crm.comcast.Genericutility.Javautility;
import com.crm.comcast.Genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcontactwithoutmandatory {

	public static void main(String[] args) throws Throwable 
	{
		//Create object for WEbdriver utility class
		WebDriverUtility wbl=new WebDriverUtility();
		Fileutility flib=new Fileutility();
		Excelutility exlib=new Excelutility();
		String URL=flib.getpropertykeyvalue("url");
		String USER =flib.getpropertykeyvalue("username");
	    String PASS=flib.getpropertykeyvalue("pass");
		String BROWSER=flib.getpropertykeyvalue("browser");
	    WebDriverManager.chromedriver().setup();
				   

	   WebDriverManager.chromedriver().setup();
	   
	   WebDriver driver=null;
	   if(BROWSER.equals("chrome"))
	   {
		   driver=new ChromeDriver();
	   }
	   else if (BROWSER.equals("firefox"))
	   {
		driver=new FirefoxDriver();
	}
	  wbl.waituntilelementvisibilityDom(driver);
	   driver.get(URL);
	  	//launch url
		String title = driver.getTitle();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USER);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wbl.acceptAlert(driver);
		Thread.sleep(5000);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbl.mouseOver(driver, ele1);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();

	}

}
