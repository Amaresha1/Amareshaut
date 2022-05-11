package com.crm.comcost.OrgTest;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.Excelutility;
import com.crm.comcast.Genericutility.Fileutility;
import com.crm.comcast.Genericutility.Javautility;
import com.crm.comcast.Genericutility.WebDriverUtility;
import com.crm.comcast.POMrepository.Createorganization;
import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;
import com.crm.comcast.POMrepository.Organization;
import com.crm.comcast.POMrepository.Verifyorganization;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganizations
{   
	Excelutility exlib=new Excelutility();
   	@Test (dataProvider = "data")
	public void createorgTest(String orgname,String Indtype) throws Throwable 
	{
		//Create object for WEbdriver utility class
		 WebDriverUtility wbl=new WebDriverUtility();
	     Fileutility flib=new Fileutility();
         

		 //Random number
	   int randomnum = Javautility.getrandomnum();
					   
	   
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver=new ChromeDriver();
	   wbl.waituntilelementvisibilityDom(driver);
	  
		//login to application
	   Login lgn=new Login(driver);
	   lgn.LoginToapp();
	   
	   //Navigate to organization
	   Homepage hp=new Homepage(driver);
	   hp.getOrganzation_link().click();
	   
	   //Create organiztion
	   Organization op=new Organization(driver);
	   op.getCreateorganization_link().click();
	   
	   Createorganization cop=new Createorganization(driver); 
	   cop.createneworgnizationwithindtype(orgname, Indtype);
	   
	   //verify the organization
	   Verifyorganization vo=new Verifyorganization(driver);
	   vo.Organizationverification(orgname);
	   
	   //logout
	   hp.logout();
	   //close the application
	   driver.close();
	}
    @DataProvider(name="data")
	  public Object[][] getData() throws Throwable
	  {
		   Object[][] data = exlib.getdatafordataprovider("Org");
		   return data;

	  }
}
