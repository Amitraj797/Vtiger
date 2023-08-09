package com.Crm.Vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulation {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
		String worldpop=driver.findElement(By.xpath("//div[@id='maincounter-wrap']/descendant::div[@class='maincounter-number']")).getText();
		String birth_today = driver.findElement(By.xpath("//div[text()='Births today ']/../descendant::span[@rel='births_today']")).getText();
		String death_today = driver.findElement(By.xpath("//div[text()='Deaths today ']/../descendant::span[@rel='dth1s_today']")).getText();
		String growth_today = driver.findElement(By.xpath("//div[text()='Population Growth today ']/../descendant::span[@rel='absolute_growth']")).getText();
		String birth_year = driver.findElement(By.xpath("//div[text()='Births this year ']/../descendant::span[@rel='births_this_year']")).getText();
		String death_year = driver.findElement(By.xpath("//div[text()='Deaths this year ']/../descendant::span[@rel='dth1s_this_year']")).getText();
		String growth_year = driver.findElement(By.xpath("//div[text()='Population Growth this year ']/../descendant::span[@rel='absolute_growth_year']")).getText();
		
		while(true)
		{
			System.out.println("World Population is "+worldpop);
			System.out.println("Today ");
			System.out.println("Birth today is "+birth_today);
			System.out.println("Death today is "+death_today);
			System.out.println("Population Growth today is "+growth_today);
			System.out.println("This Year");
			System.out.println("Birth this year "+birth_year);
			System.out.println("Death this year "+death_year);
			System.out.println("Population Growth this year "+growth_year);
		}
	}

}
