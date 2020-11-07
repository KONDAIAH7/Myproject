package com.myproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myproject.qa.base.TestBase;

public class Summarypage extends TestBase
{

	@FindBy(xpath="//tbody/tr[@id='ins_2348']/td[2]/div[1]/span[4]/button[1]/span[2]") 
	WebElement inspectionicon;
	
	//@Findby()
}
