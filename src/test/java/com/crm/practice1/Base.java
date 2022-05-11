package com.crm.practice1;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base
{
	public class Baseclass 
	{
	@BeforeSuite
	public void bs()
	{
		System.out.println("I am before suite");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("I am before test");
	}
	@BeforeClass
	public void bc()
	{
		System.out.println("I am before class");
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("I am before method");
	}
	@Test
	public void test1()
	{
		System.out.println(" i am tester");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("I am after method");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("I am after class");
	}
	@AfterTest
	public void at()
	{
		System.out.println("I am after test");
	}
}
}