package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon5Star {
	public static void main(String[] args) {
			String actual="4.5 out of 5 stars";
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			List<WebElement> allrating = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-n')]/ancestor::div[contains(@class,'a-section a-spacing-s')]/descendant::i[contains(@class,'a-icon a-icon-s')]"));
			for(WebElement rating:allrating)
			{
				if(rating.getText().contains(actual))
				{
					String price=driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-n')]/ancestor::div[contains(@class,'a-section a-spacing-s')]/descendant::span[@class='a-price-whole']")).getText();
					System.out.println(price);
				}
			}
	}

}
