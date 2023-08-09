package com.Crm.Vtiger.Practice;

import java.io.IOException;

import com.Crm.Vtiger.genricUtility.ExcelUtility;
import com.Crm.Vtiger.genricUtility.FileUtility;
import com.Crm.Vtiger.genricUtility.JavaUtility;

public class GenericUtilityPractice {
	public static void main (String[] args) throws IOException{
		FileUtility fu=new FileUtility();
		String URL=fu.getDataFromProperty("url");
		System.out.println(URL);
		
		ExcelUtility eu=new ExcelUtility();
		String orgname=eu.getTheDataFromExcel("Sheet1", 0, 0);
		System.out.println(orgname);
		
		JavaUtility ju=new JavaUtility();
		System.out.println(ju.currentDate());
		System.out.println(ju.systemDate());
		
	}

}
