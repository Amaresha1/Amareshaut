package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns 
{
   public Campaigns(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy (xpath = "//img[@alt='Create Campaign...']")
   private WebElement createcampaign_link;

public WebElement getCreatecampaign_link() {
	return createcampaign_link;
}
   
   
}
