package com.Crm.Vtiger.Practice;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Fetch {
	public static void main(String[] args) throws CsvValidationException {
		String cell[];
		try {
//			To read the data from CSV File
			FileReader fr=new FileReader("./src/test/resources/test.csv");
			CSVReader reader=new CSVReader(fr);
//			navigate to each cell data
			while((cell=reader.readNext())!=null)
			{
				String keyword=cell[0];
				System.out.println(keyword);
			}}
			catch(IOException e)
			
			{
				e.printStackTrace();
			}
		}   
	}

