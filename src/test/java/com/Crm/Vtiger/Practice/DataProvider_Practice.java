package com.Crm.Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Practice {
	@DataProvider
	public Object[][] data()
	{
	  Object[][] data=new Object[3][3];
	  data[0][0]="Nokia";
	  data[0][1]=10000;
	  data[0][2]=4.7;
	  data[1][0]="samsung";
	  data[1][1]=30000;
	  data[1][2]=4.6;
	  data[2][0]="OnePlus";
	  data[2][1]=40000;
	  data[2][2]=4.8;
	  return data;
	}
	
	@Test(dataProvider="data")
	public void datafetch(String name,long price,double rating)
	{
		System.out.println(name+"------->"+price+"------>"+rating);
	}
	
}
