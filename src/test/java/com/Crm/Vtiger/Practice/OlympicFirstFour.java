package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicFirstFour {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> countryname = driver.findElements(By.xpath("(//span[@class='styles__CountryName-sc-fehzzg-6 jYXabZ'])[position()<5]"));
		for(WebElement name:countryname)
		{
			System.out.print(name.getText());
			List<WebElement> goldmedal = driver.findElements(By.xpath("(//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq'])[position()<"+5+"]"));
			for(WebElement gold:goldmedal)
			{
			System.out.print("  " + gold.getText());
			}
			System.out.println();
		}
	}

}
