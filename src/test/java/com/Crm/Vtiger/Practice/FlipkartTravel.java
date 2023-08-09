package com.Crm.Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTravel {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("[alt='Travel']")).click();
		driver.findElement(By.cssSelector("[data-checked='true']")).click();
		driver.findElement(By.name("0-departcity")).sendKeys("Bangaluru");
		driver.findElement(By.name("0-arrivalcity")).sendKeys("Mumbai");
		driver.findElement(By.cssSelector("[name='0-datefrom']")).click();
	}

}
