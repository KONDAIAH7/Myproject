package com.myproject.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.qa.base.TestBase;
import com.myproject.qa.pages.Homepage;
import com.myproject.qa.pages.Inspecteddatapage;
import com.myproject.qa.pages.Loginpage;
import com.myproject.qa.pages.Newinspectionpage;
import com.myproject.qa.pages.Summarypage;

public class Newinspectionpagetest extends TestBase
{
	Loginpage LgnPage;
	Homepage HmePage;
	Newinspectionpage newinspectpage;
	Inspecteddatapage inspecteddatapage;
	
	
	public Newinspectionpagetest()
	{
		super();
	}
	//testcase should be separated---independent to each other
	  //Before each testcase login browser
	    // testcase execute
		   //After testcase close browser
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		LgnPage=new Loginpage();
		newinspectpage=new Newinspectionpage();
		inspecteddatapage=new Inspecteddatapage();
			
		HmePage=LgnPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		newinspectpage=HmePage.clickonnewinspectionlink();
		 Thread.sleep(5000);	
	}
	
	@Test
	public void verifynewinspectiontest() throws InterruptedException
	{
		inspecteddatapage=newinspectpage.verifynewinspection("1452711");
		
	}
	
	
	
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	} 
	*/
	
	
	
	
	
}

