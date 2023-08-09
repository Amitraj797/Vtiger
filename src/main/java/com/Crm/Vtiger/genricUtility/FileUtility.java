package com.Crm.Vtiger.genricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This methos is used to fetch data from Properties file.
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String getDataFromProperty(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	
}
