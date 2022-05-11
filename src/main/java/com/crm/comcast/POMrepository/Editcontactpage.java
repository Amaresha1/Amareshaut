package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Editcontactpage
{
 public Editcontactpage(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
 
 @FindBy(xpath="//input[@name='lastname']")
 private WebElement enterlastname;
 
 @FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement save_btn;
 
 @FindBy (id = "email")
 private WebElement emailedt;


public WebElement getEnterlastname() 
{
	return enterlastname;
}

public WebElement getSave_btn() 
{
	return save_btn;
}

public WebElement getEmailedt() {
	return emailedt;
}

public void editcontact(String email)
{
	emailedt.clear();
	emailedt.sendKeys(email);
	save_btn.click();
}
 
}
