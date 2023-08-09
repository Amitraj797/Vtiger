package com.Crm.Vtiger.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
//		fetch all the links from anchor tag
	     List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
//	     Create a empty arraylist
	     List<String> brokenlinks = new ArrayList<String>();
	     for (int i = 0; i < alllinks.size(); i++) {
			String links = alllinks.get(i).getAttribute("href");
			int statuscode=0;
//			create url
			try {
				URL url=new URL(links);
				URLConnection conn = url.openConnection();
				HttpURLConnection urlc=(HttpURLConnection)conn;
				statuscode=urlc.getResponseCode();
				 if(statuscode>=400) {
			            brokenlinks.add(links+" "+statuscode);
			          }
			} catch (Exception e) {
				continue;
			}
			System.out.println(brokenlinks);                                                                                                                                                                           
		}
	}

}
