package com.crm.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {

	public static void main(String[] args) throws Exception
	{
		Date d=new Date();
		String[] d1 = d.toString().split(" ");
		String day = d1[0];
		String month = d1[1];
		String date = d1[2];
		String yr = d1[5];
		String traveldate=day+" "+month+" "+date+" "+yr;
		System.out.println(traveldate);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        Actions act=new Actions(driver);
        act.moveByOffset(10,10).click().perform();
        WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
        WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
        src.sendKeys("mumbai");
        driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(dst));    
        dst.sendKeys("bengaluru");
        driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='departure']")).click();
        Thread.sleep(2000);
       
        driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
	}

}
