package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
	public Homepage(WebDriver driver)
	{ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy (linkText = "Organizations")
private WebElement organzation_link;

@FindBy (linkText = "Contacts")
private WebElement contacts_link;

@FindBy (linkText = "Products")
private WebElement products_link;

@FindBy (linkText = "Documents")
private WebElement Documents_link;

@FindBy(xpath ="//a[.='Sign Out']")
private WebElement logout_link;

@FindBy (xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
private WebElement more_link;

@FindBy(xpath = "//a[.='Campaigns']")
private WebElement campaign_link;


@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstrator_link;

public WebElement getOrganzation_link() {
	return organzation_link;
}

public WebElement getContacts_link() {
	return contacts_link;
}

public WebElement getProducts_link() {
	return products_link;
}

public WebElement getLogout_link() {
	return logout_link;
}

public WebElement getAdminstrator_link() {
	return adminstrator_link;
}
   
public WebElement getCampaign_link() {
	return campaign_link;
	
}

public WebElement getDocuments_link() {
	return Documents_link;
}

public WebElement getMore_link() {
	return more_link;
}

public void logout()
{
	Actions act =new Actions(driver);
	act.moveToElement(adminstrator_link).perform();
	logout_link.click();
}

public void naviagtetomore()
{
	Actions ac=new Actions(driver);
	ac.moveToElement(more_link).perform();
}

}