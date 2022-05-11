package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.Genericutility.Fileutility;

public class Login //Create java class for every page
{  
	WebDriver driver;
	public Login(WebDriver driver)  //Create an default construtor to get object of pom class
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

@FindBy (name="user_name") //Locate all the elements by using Findby annotation
private WebElement username;

@FindBy (name="user_password")
private WebElement password;

@FindBy(id="submitButton")
private WebElement lgn_btn;


public WebElement getUsername() 
{
	return username;
}

public WebElement getPassword() 
{
	return password;
}

public WebElement getLgn_btn() 
{
	return lgn_btn;
}



   Fileutility flib=new Fileutility();
  public void LoginToapp() throws Throwable   //Business libraries
  {
	  driver.get(flib.getpropertykeyvalue("url"));
	username.sendKeys(flib.getpropertykeyvalue("username"));
	password.sendKeys(flib.getpropertykeyvalue("pass"));
	lgn_btn.click();
 }
  
  public void Loginapp(String userName,String passWord) throws Throwable   //Business libraries
  {
	username.sendKeys(userName);
	password.sendKeys(passWord);
	lgn_btn.click();
 }
  

}
