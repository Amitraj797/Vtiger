package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Crm.Vtiger.genricUtility.WebDriverUtility;

public class FlipkartAddToCart {
	public static void main(String[] args) {
	WebDriverUtility wdu=new WebDriverUtility();	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	try {
		
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	WebElement fashionicon = driver.findElement(By.xpath("//img[@alt='Fashion']"));
//	Thread.sleep(2000);
//	Actions act=new Actions(driver);
//	act.moveToElement(fashionicon).perform();
	wdu.moveToElement(driver, fashionicon);	

	driver.findElement(By.xpath("//a[text()='Men Footwear']")).click();
//	wdu.moveToElement(driver, menfoot);
//	wdu.click(driver,menfoot);
	driver.findElement(By.xpath("//img[contains(@src,'https://rukminim2.flixcart.com/image/612/612/l3')]")).click();
	
	String mainid = driver.getWindowHandle();
	Set<String> allid = driver.getWindowHandles();
	for(String id:allid)
	{
		if(!(id.contains(mainid))) {
			driver.switchTo().window(id);
		}
	}
	WebElement colour=	driver.findElement(By.xpath("//img[contains(@src,'https://rukminim2.flixcart.com/image/180/180/l3vxbbk0/slipper-flip-flop/v')]"));
	wdu.scrollThePageToElement(driver, colour);
	driver.findElement(By.xpath("//*[name()='svg' and @class='_1KOMV2']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[contains(@class,'RKKUf')]/div/descendant::li[@id='swatch-3-size']")).click();
	driver.findElement(By.xpath("//*[name()='svg' and @class='_1KOMV2']")).click();
	driver.findElement(By.xpath("//*[name()='svg' and @class='V3C5bO']")).click();
	}
	catch(Exception e)
	{
	 
	}
	
  }
}
