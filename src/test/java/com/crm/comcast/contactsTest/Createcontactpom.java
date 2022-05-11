package com.crm.comcast.contactsTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.BaseClass;
import com.crm.comcast.Genericutility.Excelutility;
import com.crm.comcast.Genericutility.Fileutility;
import com.crm.comcast.Genericutility.Javautility;
import com.crm.comcast.Genericutility.WebDriverUtility;
import com.crm.comcast.POMrepository.Contact_verify;
import com.crm.comcast.POMrepository.Contacts;
import com.crm.comcast.POMrepository.Createcontact;
import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;
import com.google.common.base.Verify;

public class Createcontactpom extends BaseClass
{
	@Test(groups = "SmokeTest")
	public void createnewcontactTest() throws Throwable
	{
		    //Random number
			int randomnum = Javautility.getrandomnum();
				   
		    //Read the data from Excel
		    String lastname = elib.getDatafromexcel("sheet1",1,0)+randomnum;
					
			//Naviagate to Contacts
		    Homepage hp=new Homepage(driver);
		    hp.getContacts_link().click();
			   
			   //Navigate createnewcontact
			   Contacts cp=new Contacts(driver);
			   cp.getCreatenewcontact_link().click();
			   
			   //Create new conatct
			   Createcontact ccnp=new Createcontact(driver);
			   ccnp.createnewcontact(lastname);
		 	   
			   //Verify
			   Contact_verify cvp=new Contact_verify(driver);
			   String actualval = cvp.getVerifiaction_header().getText();
			   boolean data = actualval.contains(lastname);
			   Assert.assertTrue(data,"=====Contact is not verified====");
       }
	
	  @Test(groups = "RegressionTest")
	  public void craeteconwithoutmandatTest() throws
	  Throwable
	  { 
	  
	  //Naviagate to Contacts 
		  Homepage hp=new Homepage(driver);
	        hp.getContacts_link().click();
	  
	  //Navigate createnewcontact 
	        Contacts   cp=new Contacts(driver);
	  cp.getCreatenewcontact_link().click();
	  
	  //Create new conatct
	  Createcontact ccnp=new Createcontact(driver);
	  ccnp.createconatctwithoutmandat();
	  }
	  }
	 
