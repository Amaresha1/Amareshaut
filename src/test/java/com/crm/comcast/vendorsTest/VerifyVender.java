package com.crm.comcast.vendorsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyVender {

	public static void main(String[] args) throws Throwable 
	{
		//get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Fileutility flib=new Fileutility();
		String URL=flib.getpropertykeyvalue("url");
		 String USER =flib.getpropertykeyvalue("username");
		  String PASS=flib.getpropertykeyvalue("pass");
		   String BROWSER=flib.getpropertykeyvalue("browser");	   
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
	  
	   driver.get(URL);
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//launch url
		String title = driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USER);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//navigate to vendor
		WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@name='Invoice']")).click();
		driver.findElement(By.xpath("//a[.='edit']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//textarea[@name='bill_street']"));
		ele1.clear();
		ele1.sendKeys("\"Vijayawada, Benzcircle, Gurunanak Colony,Houseno-121,pin-521286\" is erased and  \"Rema sky view appartments, 3rd floor, B-31, Murgeshpallya, KR Garden, pin-500017 \" is displayed");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//b[.='Copy Billing address']")).click();
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        act.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
        driver.close();
	}

}
