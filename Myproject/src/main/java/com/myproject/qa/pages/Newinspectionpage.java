package com.myproject.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.qa.base.TestBase;

public class Newinspectionpage extends TestBase
{
	@FindBy(xpath="//thead/tr[1]/th[8]/input[1]") WebElement enterPo;
	
	@FindBy(xpath="//tbody/tr[@id='ins_19398239']/td[1]/div[1]/button[1]/span[1]") WebElement addbutton;
	
	
	
	@FindBy(xpath="//body/div[@id='content']/div[1]/ng-view[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]/span[1]/span[3]") 
		WebElement inspectionnew;
	
	//intializing pageobjects
		public Newinspectionpage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public Inspecteddatapage verifynewinspection(String value) throws InterruptedException
		{
			enterPo.sendKeys(value);
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(4000);
			addbutton.click();
			inspectionnew.click();
			
			
			return new Inspecteddatapage();
			
		}
	
	
}
