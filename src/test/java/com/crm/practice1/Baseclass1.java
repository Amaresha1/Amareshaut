package com.crm.practice1;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Baseclass1 
{
	@BeforeSuite
	public void bs()
	{
		System.out.println("i am bs");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("i am bt");
	}
	@BeforeClass
	public void bc1()
	{
		System.out.println("I am before class1");
	}
	@BeforeMethod
	public void bm1()
	{
		System.out.println("I am before method1");
	}
	@Test
	public void test2()
	{
		System.out.println(" i am tester2");
	}
	@AfterMethod
	public void am1()
	{
		System.out.println("I am after method1");
	}
	@AfterClass
	public void ac1()
	{
		System.out.println("I am after class1");

	}
	@AfterSuite
	public void as()
	{
		System.out.println("I am after suite");
	}
}
