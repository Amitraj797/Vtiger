package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrencySelect {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> currencies = driver.findElements(By.xpath("//table[@id='countries']/descendant::td[@style='width: 122.667px;'][position()<199]"));
		String curr="Dollar";
		for(WebElement currency:currencies)
		{
			if(currency.getText().contains(curr))
			{	
				WebElement countryname = driver.findElement(By.xpath("//td[@style='width: 122.667px;']/../td[@style='width: 134.667px;']"));
				System.out.println(countryname.getText());
			}
		}
	}

}
