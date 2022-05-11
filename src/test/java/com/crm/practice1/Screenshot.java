package com.crm.practice1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.Genericutility.BaseClass;

@Listeners(com.crm.comcast.Genericutility.IListenerImp.class)
public class Screenshot extends BaseClass
{
	 @Test
     public void verifytitle()
     {
    	 System.out.println("===START===");
    	 String expected = " Administrator - Home - vtiger ".trim();
    	 String actual = driver.getTitle().trim();
    	 Assert.assertEquals(actual,expected);
    	 System.out.println("Title is verified");
    	 System.out.println("===END==="); 
}}
