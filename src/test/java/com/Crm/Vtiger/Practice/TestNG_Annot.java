package com.Crm.Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Annot {
	
	@Test(priority=2,invocationCount=2)
	public void create()
	{
		System.out.println("created");
		Assert.fail();
	}
	
	@Test(priority=-1,invocationCount=1,dependsOnMethods="create",alwaysRun=true)
	public void update()
	{
		System.out.println("updated");
	}
	
	@Test(priority=1,invocationCount=1,enabled=false)
	public void delete()
	{
		System.out.println("deleted");
	}

}
