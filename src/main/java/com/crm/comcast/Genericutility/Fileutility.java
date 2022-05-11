package com.crm.comcast.Genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility
{
   public String getpropertykeyvalue(String key) throws Throwable
   {
	   FileInputStream fis=new FileInputStream(IConstants.PROPERTYFILEPATH);
	   Properties pboj=new Properties();
	   pboj.load(fis);
	   return pboj.getProperty(key);
	   
	}
}
