package com.Crm.Vtiger.Practice;

import org.testng.annotations.Test;

public class FetchData {
	@Test(dataProviderClass=Ddt_StoreData.class,dataProvider="data")
	public void datafetch(String name,long price,double rating)
	{
		System.out.println(name+"------->"+price+"------>"+rating);
	}

}
 