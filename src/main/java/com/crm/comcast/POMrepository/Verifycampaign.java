package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verifycampaign 
{
   public Verifycampaign(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   @FindBy(xpath = "//span[@class='dvHeaderText']")
	  private WebElement verifiaction_header;
    
   public WebElement getVerifiaction_header() {
	return verifiaction_header;
}



}
