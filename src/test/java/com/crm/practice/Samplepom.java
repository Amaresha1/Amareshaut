package com.crm.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.POMrepository.Login;

public class Samplepom {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		Login lgn=new Login(driver);
		lgn.LoginToapp();
	}

}
