package com.crm.practice1;

import org.testng.annotations.Test;

public class SampleDepends 
{
	@Test ()
	  public void SignupTest()
	  {
		 System.out.println("i am signup"); 
		 int[] arr= {1,2,3};
		 System.out.println(arr[2]);
	  }
	  
	  @Test (dependsOnMethods = "SignupTest")
	  public void LoginTest()
	  {
		  System.out.println("I am login");
	  }
	  @Test  (dependsOnMethods = "LoginTest")
	  public void HomepageTest()
	  {
		  System.out.println("I am Homepage");
	  }
}
