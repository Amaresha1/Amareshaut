package com.crm.comcast.vendorsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.BaseClass;
import com.crm.comcast.Genericutility.Excelutility;
import com.crm.comcast.Genericutility.Fileutility;
import com.crm.comcast.Genericutility.Javautility;
import com.crm.comcast.Genericutility.WebDriverUtility;
import com.crm.comcast.POMrepository.Campaigns;
import com.crm.comcast.POMrepository.Createcampaign;
import com.crm.comcast.POMrepository.Createnewproduct;
import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;
import com.crm.comcast.POMrepository.Products;
import com.crm.comcast.POMrepository.Verifycampaign;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Campains extends BaseClass {

    @Test(groups = "SmokeTest")
	public void createcampaignTest() throws Throwable 
	{  
		     //Random number
		     int randomnum = Javautility.getrandomnum();
		   
		     //Read the data from Excel
             String productname = elib.getDatafromexcel("sheet1",3,0)+randomnum;
             String campaign = elib.getDatafromexcel("sheet1",1,0)+randomnum;

					   
             //navigate to campaigns
			   Homepage hp=new Homepage(driver);
			   hp.naviagtetomore();
			   hp.getCampaign_link().click();
			   //Create new campaign
			   Campaigns cp=new Campaigns(driver);
			   cp.getCreatecampaign_link().click();
			   Createcampaign cnp=new Createcampaign(driver);
			   cnp.Createcampaign(campaign);
			   //Verify campaign
			   Verifycampaign vc=new Verifycampaign(driver);
			   String actual = vc.getVerifiaction_header().getText();
			   boolean data = actual.contains(campaign);
			   Assert.assertTrue(data,"==Campaign is not created ===");
	}          
    @Test(groups = "RegressionTest")
	public void campaignwithproductTest() throws Throwable 
	{
		      //Random number
		      int randomnum = Javautility.getrandomnum();
		   
		      //Read the data from Excel
              String productname = elib.getDatafromexcel("sheet1",3,0)+randomnum;
              String campaign = elib.getDatafromexcel("sheet1",1,0)+randomnum;
			   
			   //navigate to products
			   Homepage hp=new Homepage(driver);
			   hp.getProducts_link().click();
			   //Create new product
			   Products pg=new Products(driver);
			   pg.getCreatenewproduct_link().click();
			   
			   Createnewproduct cnp=new Createnewproduct(driver);
			   cnp.createnewproduct(productname);
			   
			   //Navigate to campaigns
			   hp.naviagtetomore();
			   hp.getCampaign_link().click();
			   //naviagte to create new campaign
			   Campaigns cp=new Campaigns(driver);
			   cp.getCreatecampaign_link().click();
			   
			   //Create new campaign
			   Createcampaign ccp=new Createcampaign(driver);
			   ccp.Createcampaign(campaign,productname);
			   
			   //Verify
			   Verifycampaign vc=new Verifycampaign(driver);
			   String actualvalue = vc.getVerifiaction_header().getText();
			   
			   boolean data1 = actualvalue.contains(campaign);
			   Assert.assertTrue(data1,"===Campaign is not created===");
			}
}
