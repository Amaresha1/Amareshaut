package com.crm.practice1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.BaseClass;

public class Homepageverify extends BaseClass 
{
     @Test
     public void verifytitle()
     {
    	 System.out.println("===START===");
    	 String expected = " Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM".trim();
    	 String actual = driver.getTitle().trim();
    	 Assert.assertEquals(actual,expected);
    	 System.out.println("Title is verified");
    	 System.out.println("===END==="); 
     }

     @Test
     public void verifyhome()
     {
    	 System.out.println("===START===");
    	  boolean flag = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isDisplayed();
    	 Assert.assertTrue(flag);
    	 System.out.println("===END===");	 
     }

}
