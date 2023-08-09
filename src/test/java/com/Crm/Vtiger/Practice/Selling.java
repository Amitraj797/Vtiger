package com.Crm.Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selling {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_sell_T3']")).click();
		driver.findElement(By.xpath("//a[@data-ld-append='Nav_Cross_T3']")).click();
	
	}
}
