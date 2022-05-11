package com.crm.comcast.POMrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.Genericutility.WebDriverUtility;

public class Createcampaign extends WebDriverUtility
{
	WebDriver driver;
	public Createcampaign(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
   @FindBy (xpath = "//input[@name='campaignname']")
   private WebElement campaignnametextfield;
   
   @FindBy (xpath = "//img[@title='Select']")
   private WebElement addproduct_link;
   
   @FindBy (xpath = "//input[@title='Save [Alt+S]']")
   private WebElement save_btn;

public WebElement getCampaignnametextfield() {
	return campaignnametextfield;
}

public WebElement getAddproduct_link() {
	return addproduct_link;
}

public WebElement getSave_btn() {
	return save_btn;
}
   public void Createcampaign(String campaign )
   {
	   campaignnametextfield.sendKeys(campaign);
       save_btn.click();
   }
   
   public void Createcampaign(String campaignname,String productname)
   {
	   
	   Products cp=new Products(driver);
	   campaignnametextfield.sendKeys(campaignname);
	   addproduct_link.click();
	   switchToWindow(driver,"Products&action");
	   cp.getSearch_textfield().sendKeys(productname);
	   cp.getSearch_btn().click();
	   driver.findElement(By.xpath("//a[.='"+productname+"']")).click();
	   switchToWindow(driver,"Campaigns&action");
	   save_btn.click();
	   
	 
	  
   }
}
