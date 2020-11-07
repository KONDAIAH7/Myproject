package com.myproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.myproject.qa.utility.Testutil;
import com.myproject.qa.utility.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{	
		prop=new Properties();
		FileInputStream fis;
		
			try {
				fis = new FileInputStream("E:\\TESTING\\Automation\\Myproject\\src\\main\\java\\com\\myproject\\qa\\config\\config.properties");
				prop.load(fis);
			} 
			catch (Exception e) 
			{
				System.out.println("not able to load file:"+e.getMessage());
			}
	
	}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("we do not support this browser");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		//Now create object of event listenerhandler to regester with eventfiring webdriver
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
}
