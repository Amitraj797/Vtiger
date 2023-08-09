package com.Crm.Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Olympics {

		public static void main(String[] args) throws InterruptedException {
			
	       // go to olympics and print the medals of all the countries		
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
			Thread.sleep(2000);
			driver.findElement(By.id("onetrust-pc-btn-handler")).click();
			driver.findElement(By.className("ot-pc-refuse-all-handler")).click();
			Thread.sleep(3000);
			Actions act= new Actions(driver);
			act.scrollByAmount(0, 600).perform();
			WebElement madel=driver.findElement(By.xpath("//div[@data-medal-id='total-medals-row-1']/.."));
			System.out.println(madel.getText());

		}

	}


