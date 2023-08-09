package com.Crm.Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FatchAllLink {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		for(WebElement link:alllinks)
		{
//			System.out.println(link.getText());
			FileInputStream fis=new FileInputStream("C:/Users/Lucky/Desktop/new.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet("Sheet1");
			for(int i=0;i<alllinks.size();i++)
			{
				Row row=sh.getRow(0);
				Cell cell=row.createCell(i);
				cell.setCellValue(alllinks.get(i).getAttribute("href"));
			
			}
				FileOutputStream fos=new FileOutputStream("C:/Users/Luc ky/Desktop/new.xlsx");
				book.write(fos);
				fos.close();
				
			
		}
		FileInputStream fis1=new FileInputStream("C:/Users/Lucky/Desktop/new.xlsx");
		Workbook book1 = WorkbookFactory.create(fis1);
		Sheet sh1 = book1.getSheet("Sheet1");
		for(int j=0;j<alllinks.size();j++)
		{
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh1.getRow(j).getCell(0));
			System.out.println(value);
		}
		
	}

}
