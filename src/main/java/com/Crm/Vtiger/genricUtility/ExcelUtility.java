package com.Crm.Vtiger.genricUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	/**
	 * THis method for update the data in excel sheet.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void updateExcelData(String sheet,int row,int cell, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		 Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
		 FileOutputStream fos= new FileOutputStream(Ipathconstant.excelfilepath);
		 wb.write(fos);
		 wb.close();
	}
	
	/**
	 * This method is to fetch the data from Excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getTheDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Cell cel=wb.getSheet(sheet).getRow(row).getCell(cell);
		 DataFormatter df=new DataFormatter();
		 String value = df.formatCellValue(cel);
		 return value;
	}
	
	
	/**
	 * this method is to fetch data from excel sheet for multiple set of data 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] getMultiple() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(Ipathconstant.excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("multiple");
		 int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] data =new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}

		}
		
		return data;
	}
}
