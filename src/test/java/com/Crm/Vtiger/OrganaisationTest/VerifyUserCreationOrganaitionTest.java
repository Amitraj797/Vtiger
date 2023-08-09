package com.Crm.Vtiger.OrganaisationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Crm.Vtiger.genricUtility.BaseClass;
import com.Crm.Vtiger.genricUtility.ExcelUtility;

import ObjectRepository.CreateNewOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganisationPage;


public class VerifyUserCreationOrganaitionTest extends BaseClass {
	
	@Test(dataProviderClass=ExcelUtility.class,dataProvider="getMultiple")
	public void createOrg(String orgName) throws IOException
	{
		
//		FileUtility fu=new FileUtility();
//		WebDriverUtility wdu=new WebDriverUtility();
//		JavaUtility ju=new JavaUtility();
//		int random=ju.getRandom();
		
//		Random r=new Random();
//	    int random=r.nextInt();		
//		String actualOrgName="amit"+random;
		
		
		String actualOrgName=orgName+jutil.getRandom();
//	    driver.get(futil.getDataFromProperty("url"));
//			WebDriver driver= new ChromeDriver();
//		wdu.maximize(driver);
//		wdu.implicitWait(driver);
//		String UN=fu.getDataFromProperty("username");
//		String PW=fu.getDataFromProperty("password");
		
		
//		LoginPage log=new LoginPage(driver);
//		log.Login(UN, PW);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(fu.getDataFromProperty("username"));
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(fu.getDataFromProperty("password"));
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		HomePage hm=new HomePage(driver);
		hm.orgClick();
//		driver.findElement(By.linkText("Organizations")).click();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.addOrgIconClick();
//		driver.findElement(By.xpath("//img[contains(@title,'Cr')]")).click();
		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		cop.createOrg(actualOrgName);
		
//		driver.findElement(By.cssSelector("[name='accountname']")).sendKeys(actualOrgName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String expectedOrgName = driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		Assert.assertTrue(expectedOrgName.contains(actualOrgName));
		System.out.println("pass");
		
//		hm.logout(driver);
		
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
//		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}

}


