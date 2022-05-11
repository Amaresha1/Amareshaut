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
import com.crm.comcast.POMrepository.Deletecontactpage;
import com.crm.comcast.POMrepository.Editcontactpage;
import com.crm.comcast.POMrepository.Editcontactverify;
import com.crm.comcast.POMrepository.Homepage;
import com.crm.comcast.POMrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editanddeletecontactpom extends BaseClass{

	@Test(groups = "RegressionTest")
	public void edicontactTest()throws Throwable 
	{
				   
		//Random number
	      int randomnum = Javautility.getrandomnum();
				   
	    //Read the data from Excel
        String email = elib.getDatafromexcel("Sheet2",2,0)+randomnum;
        
        //Navigate to Contact
        Homepage hp=new Homepage(driver);
        hp.getContacts_link().click();
        
        //Navigate to edit conatct page
        Contacts cp=new Contacts(driver);
        cp.getEdit_link().click();
        
        //Edit contact
        Editcontactpage ecp=new Editcontactpage(driver);
        ecp.editcontact(email);
        
        //Verify
        Editcontactverify ecv=new Editcontactverify(driver);
        String act = ecv.getEmailtextfiled().getText();
        
        boolean data = act.contains(email);
        Assert.assertTrue(data,"====Contact is edited=====");
      }
	 
	  @Test(groups = "RegressionTest")
	  public void deletecontactTest() throws Throwable
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
		   Assert.assertTrue(data,"===Contact is Created====");
		   //Navigate back to conatcts page
		   hp.getContacts_link().click();
		   
		   //delete contact
		   Deletecontactpage dcp=new Deletecontactpage(driver);
		   dcp.deletecontactverify(lastname);
		   
		   //verify
		   String actdata = dcp.getNocontactsfound_img().getText();
		   data=actdata.equals("No Contact Found !");
		   Assert.assertTrue(data,"==Contact is Deleted Successful===");
	   
	}

}