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

import com.crm.comcast.Genericutility.BaseClass;
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

public class Createorganizationswithdataprovider extends BaseClass {
    @Test(dataProvider = "data") 
	public void createorgTest(String orgname) throws Throwable 
	{
		
        //Random number
	   int randomnum = jlib.getrandomnum();
	   
	   //Navigate to organization
	   Homepage hp=new Homepage(driver);
	   hp.getOrganzation_link().click();
	   
	   //Create organiztion
	   Organization op=new Organization(driver);
	   op.getCreateorganization_link().click();
	   
	   Createorganization cop=new Createorganization(driver);
	   cop.createneworgnization(orgname+randomnum);
	   
	   //verify the organization
	   Verifyorganization vo=new Verifyorganization(driver);
	   vo.Organizationverification(orgname);
	    }
	   //Read data from Excel & provide to dataprovider
	  
	   @DataProvider(name="data")
	  public Object[][] getData() throws Throwable
	  {
		   Object[][] orgname = elib.getdatafordataprovider("sheet3");
		   return orgname;

	  }
	   	   
	}

