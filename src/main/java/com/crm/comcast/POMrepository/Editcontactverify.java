package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Editcontactverify 
{
  public Editcontactverify(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);  
  }
  
  @FindBy(xpath = "//a[@href='index.php?module=Contacts&parenttab=Marketing&action=DetailView&record=127']/../../td[7]")
  private WebElement emailtextfiled;

public WebElement getEmailtextfiled() {
	return emailtextfiled;
}

public void Editverification(String Expecteddata)
 {
	 String actualdata=emailtextfiled.getText();
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