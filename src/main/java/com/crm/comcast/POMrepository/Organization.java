package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization 
{
   public Organization(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
   private WebElement createorganization_link;
   

   @FindBy(xpath="//input[@value='Search...']")
   private WebElement search_textfield;

   
   public WebElement getCreateorganization_link() {
	return createorganization_link;
}

public WebElement getSearch_textfield() {
	return search_textfield;
}
   
   
	
}
