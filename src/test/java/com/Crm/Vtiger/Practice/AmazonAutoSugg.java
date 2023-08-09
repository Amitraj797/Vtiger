package com.Crm.Vtiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutoSugg {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung s20");
//		driver.findElement(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction' and @aria-label='samsung s20']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='left-pane-results-container']/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction' and @aria-label='samsung s20']")).click();
		List<WebElement> allsug = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
		for(WebElement sug:allsug)
		{
			if(sug.getText().equalsIgnoreCase("Samsung s20"))
			{
				sug.click();
				break;
			}
		}
		}

}
