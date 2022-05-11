package com.crm.comcast.Genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
   /**
    *This class contains generic methods of Webdriver
    * Amaresha
    */
	public void waituntilelementvisibilityDom(WebDriver driver)
	{
		
		/**
		 * Implicit wait 
		 */
		driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITTIMEINSECONDS,TimeUnit.SECONDS);
	}
	
	   public void waitForpageloaded(WebDriver driver,WebElement element)
	   {
		   /**
		    * Explicit wait until page gets loaded & visibility of element 
		    */
		  WebDriverWait wait = new WebDriverWait(driver,IConstants.EXPLICITTIMEINSECONDS);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   /**
	    * this methods enables user to handle dropdown using visible text
	    * @param element
	    * @param option
	    */
	       
	   public void select(WebElement element, String option)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(option);
		   
	   }
	   
	   /**
	    * this methods enables user to handle dropdown using index
	    * @param element
	    * @param index
	    */
	      
	   public void select(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }
	   
	   /**
	    * This method will perform mouse over action
	    * @param driver
	    * @param element
	    */
	   
	   public void mouseOver(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	   
	   /**
	    * This method performs right click operation 
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   
	   /**
	    * This method helps to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
	   }
	   /**
	    * Accept alert 
	    * @param driver
	    */
	   
	   public void acceptAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }
	   
	   /**
	    * Cancel Alert
	    * @param driver
	    */
	   public void cancelAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }
	  
	   public void gettakescreenshot(WebDriver driver) throws IOException
	   {
		   
		   Javautility flib=new Javautility();
		   String date = flib.getsystemDatewithformat();
		   TakesScreenshot ts=(TakesScreenshot) driver;
		   File src = ts.getScreenshotAs(OutputType.FILE);
		   File dst=new File("./photos"+date);
		   org.openqa.selenium.io.FileHandler.copy(src, dst);
		   }

}
