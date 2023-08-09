package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmzoneIphone {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		 List<WebElement> alllinks = driver.findElements(By.xpath("//*"));
		 String name="Apple iPhone 14";
		 for(WebElement link:alllinks)
		 {
			 if(link.getText().contains(name))
			 {
				String price = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section']/descendant::span[@class='a-price-whole']")).getText();
				System.out.println(price);
			 }
		 }
		
		
	}

}
