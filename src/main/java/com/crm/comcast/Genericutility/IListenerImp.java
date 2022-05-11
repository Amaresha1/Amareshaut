package com.crm.comcast.Genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class IListenerImp implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		Javautility jlib=new Javautility();
		String testcasename = result.getMethod().getMethodName();
        EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
        File src = edriver.getScreenshotAs(OutputType.FILE);
        File dst=new File("./Screeenshot/"+testcasename+"_"+jlib.gettimestamp()+".png");
        try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
	}

	public Class<? extends ITestNGListener>[] getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValue(Class<? extends ITestNGListener>[] value) {
		// TODO Auto-generated method stub
		
	}

	}
