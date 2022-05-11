package com.crm.practice1;

import java.util.concurrent.PriorityBlockingQueue;

import org.testng.annotations.Test;

public class Samplepriority 
{
  @Test (priority = 1)
  public void SignupTest()
  {
	 System.out.println("i am signup"); 
  }
  
  @Test (priority=2)
  public void LoginTest()
  {
	  System.out.println("I am login");
  }
  @Test  (priority = 3)
  public void HomepageTest()
  {
	  System.out.println("I am Homepage");
  }
}
