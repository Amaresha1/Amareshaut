package com.crm.comcast.Genericutility;
/**
 * Amaresh
 */
import java.sql.Date;
import java.util.Random;

public class Javautility 
{
	
   public static int getrandomnum()
   {
	   /**
	    * it is used to generate random number
	    */
	   Random raandom=new Random();
	   int randomnum = raandom.nextInt(1000);
	   return randomnum;
   }
   
  public String getsystemDatewithformat()
  {
	  /**
	   * it is used to get systemdate in YYYY-DD-MM format
	   */
	  java.util.Date date=new java.util.Date();
	  String d = date.toString();
	  String[] arr = d.split(" ");
	  String yy = arr[5];
	  String dd = arr[2];
	  int mm = date.getMonth()+1;
	  String format=yy+"-"+dd+"-"+mm;
	  return format;
  }
  public String gettimestamp()
  {
	  /**
	   * it is used to get systemdate in YYYY-DD-MM format
	   */
	  java.util.Date date=new java.util.Date();
	  return date.toString().replace(" ","_").replace(":", "_");
	
  }
  }
