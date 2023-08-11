package com.Crm.Vtiger.contactsTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Crm.Vtiger.genricUtility.BaseClass;
import com.Crm.Vtiger.genricUtility.ExcelUtility;

import ObjectRepository.ContactPage;
import ObjectRepository.CreateNewContPage;
import ObjectRepository.HomePage;



@Listeners(com.Crm.Vtiger.genricUtility.ListenerImplementation.class)
public class VerifyuserCreateContactsTest extends BaseClass{
	
	@Test(dataProviderClass=ExcelUtility.class,dataProvider="getMultiple")
	public void createContect(String lastn)  throws Throwable
	{
		
//		FileUtility fu=new FileUtility();
//		WebDriverUtility wdu=new WebDriverUtility();
//		JavaUtility ju=new JavaUtility();
//		int random=ju.getRandom();
		lastn="raj"+jutil.getRandom();
//		WebDriver driver = new ChromeDriver();
//		wdu.maximize(driver);
//		driver.manage().window().maximize();
//		wdu.implicitWait(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(fu.getDataFromProperty("url"));
//		String UN=fu.getDataFromProperty("username");
//		String PW=fu.getDataFromProperty("password");
//		
//		driver.get("http://localhost:8888");
//		LoginPage lp=new LoginPage(driver);
//		lp.Login(UN, PW);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("root");
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		HomePage hp=new HomePage(driver);
		hp.ContClick();
		
//		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		ContactPage cp=new ContactPage(driver);
		cp.clickContact();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		CreateNewContPage cncp=new CreateNewContPage(driver);
		cncp.cretCont(lastn);
//		driver.findElement(By.name("lastname")).sendKeys(lastn);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ActualName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ActualName.contains(lastn));
		System.out.println("pass");
		
//		hp.logout(driver);
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
//		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	
	}

}
