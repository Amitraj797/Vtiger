package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkatsamsungS20 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		WebElement popup = driver.findElement(By.xpath("//button[text()='✕']"));
		if(popup.isEnabled()) {
			popup.click();
		}
		else {
			
		}
		driver.findElement(By.name("q")).sendKeys("samsung s20");
		Thread.sleep(3000);
		List<WebElement> alloption = driver.findElements(By.xpath("//ul[contains(@class,'UFBK')]/li"));
		for(WebElement option:alloption)
		{
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("samsung s20"))
			{
				option.click();
				break;
			}
		}
	}
}
