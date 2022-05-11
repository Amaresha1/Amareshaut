package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.Genericutility.WebDriverUtility;

public class Createcontact extends WebDriverUtility
{
	WebDriver driver;
 public Createcontact(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
  
 @FindBy(xpath="//input[@name='lastname']")
 private WebElement enterlastname;
 
 @FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement save_btn;

public WebElement getEnterlastname() {
	return enterlastname;
}

public WebElement getSave_btn() 
{
	return save_btn;
}

public void createnewcontact(String lastname)
{
	enterlastname.sendKeys(lastname);
	save_btn.click();
}
public void createconatctwithoutmandat()
{
	save_btn.click();
	acceptAlert(driver);
}
 
}
