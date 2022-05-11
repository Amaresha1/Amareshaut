package com.crm.comcast.POMrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.Genericutility.WebDriverUtility;

public class Deletecontactpage extends WebDriverUtility
{
	WebDriver driver;
 public Deletecontactpage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 
 @FindBy(xpath="//input[@value='Delete']/../input[1]")
 private WebElement delete_btn;
 
 @FindBy (xpath = "//input[@name='search_text']")
 private WebElement search_edt;

 @FindBy (xpath = "//input[@name='submit']")
 private WebElement search_btn;

 @FindBy(xpath = "//span[@class='genHeaderSmall']")
 private WebElement nocontactsfound_img;

public WebElement getDelete_btn() {
	return delete_btn;
}

public WebElement getSearch_edt() {
	return search_edt;
}

public WebElement getSearch_btn() {
	return search_btn;
}

 public WebElement getNocontactsfound_img() {
	return nocontactsfound_img;
}

public void deletecontactverify(String contactname)
 {
	 driver.findElement(By.xpath("//a[.='"+contactname+"']/../../td[1]")).click();
	 delete_btn.click();
	 acceptAlert(driver);
	 search_edt.sendKeys(contactname);
	 search_btn.click();
 }
}
