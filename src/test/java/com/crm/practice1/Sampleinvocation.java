package com.crm.practice1;

import org.testng.annotations.Test;

public class Sampleinvocation 
{
	@Test (invocationCount = 2)
	  public void SignupTest()
	  {
		 System.out.println("i am signup"); 
		 int[] arr= {1,2,3};
		 System.out.println(arr[2]);
	  }
	  
	  @Test (invocationCount = 2)
	  public void LoginTest()
	  {
		  System.out.println("I am login");
	  }
}
