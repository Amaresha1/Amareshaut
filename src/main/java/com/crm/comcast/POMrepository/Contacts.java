package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts 
{
   public Contacts(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy(xpath = "//img[@title='Create Contact...']")
   private WebElement createnewcontact_link;
   
   @FindBy(xpath="//input[@value='Search...']")
   private WebElement search_textfield;
   
   @FindBy(xpath = "//a[.='edit']/../a[1]")
   private WebElement edit_link;

public WebElement getCreatenewcontact_link() {
	return createnewcontact_link;
}

public WebElement getSearch_textfield() {
	return search_textfield;
}

public WebElement getEdit_link() {
	return edit_link;
}
 
   
   
   
}
