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
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.Excelutility;
import com.crm.comcast.Genericutility.Fileutility;
import com.crm.comcast.Genericutility.WebDriverUtility;
import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Documents {
    @Test
	public void editdocumentTest() throws Throwable
	{
		 //get the java representation object of the physical file
		   Fileutility flib=new Fileutility();
		   WebDriverUtility wlib=new WebDriverUtility();
		   Excelutility exlib=new Excelutility();
		   String BROWSER=flib.getpropertykeyvalue("browser");			 
	   	 	   
			   WebDriver driver=null;
			   if(BROWSER.equals("chrome"))
			   {
				   driver=new ChromeDriver();
			   }
			   else if (BROWSER.equals("firefox"))
			   {
				driver=new FirefoxDriver();
			}
			  
			   wlib.waituntilelementvisibilityDom(driver);
				
			   //Login to application
			   Login lgn=new Login(driver);
				
			   //naviagte to Documents
				Homepage hp=new Homepage(driver);
				hp.getDocuments_link().click();
				
				//Navigate edit Documents
				
				driver.findElement(By.xpath("//a[.='edit']")).click();
				WebElement ele = driver.findElement(By.xpath("//input[@name='notes_title']"));
				ele.clear();
				ele.sendKeys("Amaresh");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				WebElement ele1 = driver.findElement(By.xpath("//a[@title='Documents']"));
				String text = ele1.getText();
				if(text.equals("Amaresh"))
				{
					System.out.println("test case is pass");
				}
				 else
				{
					System.out.println("tc is fail");
				}
				
				//logout to application
			    hp.logout();


	}

}
