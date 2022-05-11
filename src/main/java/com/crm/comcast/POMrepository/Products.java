package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products 
{
	 public Products(WebDriver driver)
	   {
		   PageFactory.initElements(driver,this);
	   }
	   
	   @FindBy(xpath ="//img[@alt='Create Product...']")
	   private WebElement createnewproduct_link;
	   @FindBy(xpath="//input[@title='Save [Alt+S]']")
	   private WebElement save_btn;
	   @FindBy(xpath="//input[@name='search_text']")
	   private WebElement search_textfield;
	   @FindBy(xpath = "//input[@name='search']")
	   private WebElement search_btn;
	
	   public WebElement getSearch_btn() 
	   {
		return search_btn;
	 }
	 public WebElement getCreatenewproduct_link() {
		return createnewproduct_link;
	 }
	 public WebElement getSave_btn() {
		return save_btn;
	  }
	public WebElement getSearch_textfield() 
	{
		return search_textfield;
	}
	
	   
	   

}
