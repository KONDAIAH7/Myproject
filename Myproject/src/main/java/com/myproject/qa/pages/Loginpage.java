package com.myproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myproject.qa.base.TestBase;

public class Loginpage extends TestBase
{
	//Page factory--OR
	
	@FindBy(id="inputEmail3") WebElement uname;
	@FindBy(id="inputPassword3") WebElement pwd;
	@FindBy(css=".btn-primary") WebElement lgnbtn;

	@FindBy(xpath="//*[@id=\"content\"]/div/ng-view/div/div/div/div[1]/div[2]/form/div[2]/div/div/select") WebElement vendordropdown;
	
	@FindBy(xpath="//body/div[@id='content']/div[1]/ng-view[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[1]/button[1]") WebElement dropbtn;
	
	@FindBy(xpath="//body/div[@id='content']/div[1]/ng-view[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/img[1]") WebElement CGSlogo;
	
	//initializing pageobjects
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	public boolean cgslogo()
	{
		return CGSlogo.isDisplayed();
	}
	public Homepage Login(String UsNme,String PasWord) throws InterruptedException
	{
		Thread.sleep(2000);
		uname.sendKeys(UsNme);
		pwd.sendKeys(PasWord);
		lgnbtn.click();
		
		Select drop=new Select(vendordropdown);
		drop.selectByValue("13");
		Thread.sleep(2000);
		dropbtn.click();
		Thread.sleep(2000);
		
		
		return new Homepage();
	}



}
