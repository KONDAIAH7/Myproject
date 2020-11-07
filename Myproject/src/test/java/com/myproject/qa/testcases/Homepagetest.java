package com.myproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.qa.base.TestBase;
import com.myproject.qa.pages.Homepage;
import com.myproject.qa.pages.Loginpage;
import com.myproject.qa.pages.Newinspectionpage;
import com.myproject.qa.pages.Summarypage;

public class Homepagetest extends TestBase
{
	Loginpage LgnPage;
	Homepage HmePage;
	Newinspectionpage newinspectpage;
	Summarypage summaryPage;
	
	public Homepagetest()
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
		summaryPage=new Summarypage();
				
		HmePage=LgnPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomepagetitletest()
	{
		String Homepagetitle=HmePage.verifyhomepagetitle();
		Assert.assertEquals(Homepagetitle, "CGS - BCQAM","Homepage title not matched");
	}
	@Test(priority=2)
	public void verifyhomepagelabeltest() 
	{
		Assert.assertTrue(HmePage.verifyhomepagelabel());
	}
	@Test(priority=3)
	public void verifyinspectionpagelink() throws InterruptedException 
	{
        
		newinspectpage=HmePage.clickonnewinspectionlink();
		 Thread.sleep(4000);	
	}
	@Test(priority=4)
	public void verifysummarypagelink() throws InterruptedException 
	{
        
		summaryPage=HmePage.clickonsummarypagelink();
		Thread.sleep(3000);	
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
