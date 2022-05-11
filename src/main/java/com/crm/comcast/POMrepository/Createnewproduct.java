/**
 * 
 */
package com.crm.comcast.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author acer
 *
 */
	public class Createnewproduct 
	{
		public Createnewproduct(WebDriver driver)
		{
			PageFactory.initElements(driver,this);	
		}

		@FindBy(xpath ="//input[@name='productname']")
		private WebElement productnameedt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		  private WebElement save_btn;

		public WebElement getProductnameedt() {
			return productnameedt;
		}

		public WebElement getSave_btn() {
			return save_btn;
		}
		
		public void createnewproduct(String productname)
		{
			productnameedt.sendKeys(productname);
			save_btn.click();
		}

	}
