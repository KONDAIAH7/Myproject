package com.myproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.qa.base.TestBase;
import com.myproject.qa.pages.Homepage;
import com.myproject.qa.pages.Loginpage;

public class Loginpagetest extends TestBase
{
	Loginpage LgnPage;
	Homepage HmePage;
	
	public Loginpagetest()
	{
		super();
	}
	//testcase should be separated---independent to each other
	//Before each testcase login browser
	   // testcase execute
	      //After testcase close browser
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LgnPage=new Loginpage();
		
			
	}
	@Test(priority=1)
	public void loginpagetititletest()
	{
		String title= LgnPage.validateloginpagetitle();
		Assert.assertEquals(title, "CGS - BCQAM");
	}
	@Test(priority=2)
	public void CGSLogoTest()
	{
		boolean flag=LgnPage.cgslogo();
		Assert.assertTrue(flag);	
	}	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException
	{
		HmePage=LgnPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
