package com.crm.comcast.contactsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class Createcontact {

	public static void main(String[] args) throws Throwable 
	{
		//Create object for WEbdriver utility class
		WebDriverUtility wbl=new WebDriverUtility();
        Fileutility flib=new Fileutility();
        Excelutility exlib=new Excelutility();
		//get the java representation object of the physical file
			   
			   String URL=flib.getpropertykeyvalue("url");
			   String USER =flib.getpropertykeyvalue("username");
			   String PASS=flib.getpropertykeyvalue("pass");
			   String BROWSER=flib.getpropertykeyvalue("browser");
			   WebDriverManager.chromedriver().setup();
			   
			 //Random number
			   int randomnum = Javautility.getrandomnum();
			   
			   //Read the data from Excel
			  String lastname = exlib.getDatafromexcel("sheet1",1,0)+randomnum;
			   
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
			//launch url

			  driver.get(URL);
			    String title = driver.getTitle();
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USER);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(5000);
				String actualval = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				   
			   if(actualval.contains(lastname))
				{
					System.out.println(lastname+"Test caseis pass");
				}
				else
				{
					System.out.println("TC is fail");
				}
				
				WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        wbl.mouseOver(driver, ele2);
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
	            driver.close();			
	}

}
