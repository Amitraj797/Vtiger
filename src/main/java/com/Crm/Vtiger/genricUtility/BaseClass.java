package com.Crm.Vtiger.genricUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public ExcelUtility eutil=new ExcelUtility();
	public FileUtility futil=new FileUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wbutil=new WebDriverUtility();
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeSuite(groups={"smoke","regression"})
	public void bsconfig()
	{
		System.out.println("database connection sucessfull");
	}
	
//	@Parameter("browser")
	@BeforeClass
	public void bcconfig(/* String browser */) throws IOException			// For Cross Browser
	{
		String Browser = futil.getDataFromProperty("browser");				//For Batch and Group Execution
//		String Browser=System.getProperty("browser");
		String URL = futil.getDataFromProperty("url");
		
		
//		RunTime Polymorphism
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println(Browser+" launched");
			
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println(Browser+" launched");
		}
		
		else
			System.out.println("invalid browser");
		
		
		sdriver=driver;
		wbutil.maximize(driver);
		wbutil.implicitWait(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void bmconfig() throws Throwable
	{
		String UN=futil.getDataFromProperty("username");
		String PW=futil.getDataFromProperty("password");
		LoginPage lp=new LoginPage(driver);
		lp.Login(UN, PW);
		System.out.println("Login action done");
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void amconfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("Logout action done");
		
	}
	
	@AfterClass(/* groups= {"smoke","regression"} */)
	public void acconfig()
	{
		driver.close();
		System.out.println("Browser closed sucessfully");
	}
	
	@AfterSuite(groups= {"smoke","regression"})
	public void asconfig()
	{
		System.out.println("Database closed sucessfully");
	}
	
}
