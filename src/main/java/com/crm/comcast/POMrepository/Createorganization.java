package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.Genericutility.WebDriverUtility;

public class Createorganization extends WebDriverUtility
{
  public Createorganization(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  @FindBy(xpath = "//input[@name='accountname']")
  private WebElement enterorgname;
  
  @FindBy(xpath = "//select[@name='industry']")
  private WebElement dropdown;

  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement save_btn;

public WebElement getEnterorgname() {
	return enterorgname;
}

public WebElement getSave_btn() 
{
	return save_btn;
}
  
  
public WebElement getDropdown() {
	return dropdown;
}

public void createneworgnization(String orgname )
{
    	enterorgname.sendKeys(orgname);
    	save_btn.click();
}
public void createneworgnizationwithindtype(String orgname,String Indtype )
{
    	enterorgname.sendKeys(orgname);
    	select(dropdown, Indtype);
    	save_btn.click();
}

}
