package com.Crm.Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmzneExcelName {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
//		driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[position()=1]")).click();
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String name = driver.findElement(By.xpath("//img[@class='s-image']/ancestor::div[@class='rush-component s-featured-result-item ']/descendant::span[text()='Apple iPhone 14 (128 GB) - Blue']")).getText();
//		System.out.println(name);
		FileInputStream fis=new FileInputStream("C:/Users/Lucky/Desktop/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		sh.createRow(0).createCell(0).setCellValue(name);
		FileOutputStream fos=new FileOutputStream("C:/Users/Lucky/Desktop/new.xlsx");
		book.write(fos);
		fos.close();
		
		FileInputStream fis1=new FileInputStream("C:/Users/Lucky/Desktop/new.xlsx");
		Workbook book1 = WorkbookFactory.create(fis1);
		Sheet sh1 = book1.getSheet("Sheet1");
		DataFormatter format=new DataFormatter();
		String name1 = format.formatCellValue(sh1.getRow(0).getCell(0));
		System.out.println(name1);
	}
	

}
