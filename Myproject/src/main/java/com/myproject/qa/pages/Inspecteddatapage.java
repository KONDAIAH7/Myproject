package com.myproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myproject.qa.base.TestBase;

public class Inspecteddatapage extends TestBase 
{

	@FindBy(xpath="//select[@id='Select1']") WebElement insptype;
	
	@FindBy(xpath="//select[@id='Select2']") WebElement status;
	
	@FindBy(xpath="//tbody/tr[2]/td[2]/div[1]/select[1]") WebElement inspector;
	
	@FindBy(xpath="//textarea[@id='Textarea1']") WebElement alerttext;
	
	@FindBy(xpath="//textarea[@id='Textarea2']") WebElement qccomment;
	
	@FindBy(xpath="//textarea[@id='Textarea3']") WebElement comments;
	
	
	//intializing pageobjects
		public Inspecteddatapage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public void verifyinspectpage(String text1,String text2,String text3) throws InterruptedException
		{
			Select inspdrop=new Select(insptype);
			Thread.sleep(3000);
			inspdrop.selectByValue("6");
			
			Select statusdrop=new Select(status);
			Thread.sleep(3000);
			statusdrop.selectByValue("8");
			
			Select inspectordrop=new Select(inspector);
			Thread.sleep(3000);
			inspectordrop.selectByValue("0");
			
			alerttext.sendKeys(text1);
	
			qccomment.sendKeys(text2);
			
			comments.sendKeys(text3);
		}
	
}
