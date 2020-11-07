package com.myproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.qa.base.TestBase;

public class Homepage extends TestBase
{

	@FindBy(xpath="//span[contains(text(),'BCQAM - PQA')]") WebElement homepagelabel;
	
	@FindBy(xpath="//body/div[@id='content']/div[1]/ng-view[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]/span[1]/span[1]") WebElement newinspectionpagelink;
	
	@FindBy(xpath="//body/div[@id='content']/div[1]/ng-view[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]/span[1]") WebElement summarypagelink;
	
	//intializing pageobjects
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	public boolean verifyhomepagelabel()
	{
		return homepagelabel.isDisplayed();
	}
	public Newinspectionpage clickonnewinspectionlink()
	{
		newinspectionpagelink.click();
		return new Newinspectionpage();
	}
	
	 public Summarypage clickonsummarypagelink()
	{
		summarypagelink.click();
		return new Summarypage();
	}
	 
		
		
		
		
		
		
	
	
	
	
	
}
