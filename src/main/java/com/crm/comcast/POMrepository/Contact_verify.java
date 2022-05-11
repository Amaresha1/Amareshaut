package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_verify 
{
  public Contact_verify(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);  
  }
  
  @FindBy(xpath = "//span[@class='dvHeaderText']")
  private WebElement verifiaction_header;

public WebElement getVerifiaction_header() {
	return verifiaction_header;
}
  
 public void Conatctverification(String Expecteddata)
 {
	 String actualdata = verifiaction_header.getText();
	 if(actualdata.contains(Expecteddata))
	 {
		 System.out.println("Conatct is created &verfied");
	 }
	 else
	 {
		 System.out.println("Contact is not created");
	 }
 }
}
