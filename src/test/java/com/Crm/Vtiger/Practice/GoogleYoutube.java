package com.Crm.Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleYoutube {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		driver.findElement(By.cssSelector("svg[class='gb_j']")).click();
		driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("span[style='background-position: 0 -1566px;']")).click();
		driver.findElement(By.cssSelector("input[id='search']")).sendKeys("Laier");
		driver.findElement(By.cssSelector("[id='search-icon-legacy']")).click();
		driver.findElement(By.cssSelector("[title='Imagine Dragons - Bad Liar (Official Music Video)']")).click();
	}

}
