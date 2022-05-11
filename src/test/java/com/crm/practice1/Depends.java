package com.crm.practice1;

import org.testng.annotations.Test;

public class Depends 
{
	@Test (dependsOnMethods = "LoginTest",priority = 0)
	  public void SignupTest()
	  {
		 System.out.println("i am signup"); 
		 int[] arr= {1,2,3};
		 System.out.println(arr[4]);
	  }
	  
	  @Test (dependsOnMethods = "HomepageTest",priority = 1)
	  public void LoginTest()
	  {
		  System.out.println("I am login");
	  }
	  @Test  (priority = 2)
	  public void HomepageTest()
	  {
		  System.out.println("I am Homepage");
	  }

}
