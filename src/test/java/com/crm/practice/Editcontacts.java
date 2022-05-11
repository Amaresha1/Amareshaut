package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editcontacts {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//launch url
		driver.get("http://localhost:8888");
		String title = driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
        driver.findElement(By.xpath("//a[.='edit']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("amar@gmail.com");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	}

}
