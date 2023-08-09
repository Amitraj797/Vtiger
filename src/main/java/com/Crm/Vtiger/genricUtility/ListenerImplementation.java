package com.Crm.Vtiger.genricUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"Test script execution started");
		test=reports.createTest(methodname);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script pass");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"test script fail");
		test.log(Status.FAIL, "test script failed");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotname=methodname+jutil.systemDate();
		
		try
		{
			String path= wutil.screenshot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
		public void onTestSkipped(ITestResult result)
		{
			String methodname=result.getMethod().getMethodName();
			System.out.println(methodname+"test script skipped");
			test.log(Status.SKIP, "test script skipped");
		}
		
		public void onStart(ITestContext context)
		{
			System.out.println("suite level execution started");
			
			ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtendReport\\report-"+new JavaUtility().systemDate()+".html");
			reporter.config().setDocumentTitle("Vtiger Application Execution Report");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setReportName("Vtiger Execution Report");
	
			reports=new ExtentReports();
			reports.attachReporter(reporter);
			reports.setSystemInfo("BaseURL", "https://localhost:8888");
			reports.setSystemInfo("Browser", "chrome");
			reports.setSystemInfo("reporter Name", "Amit");
		}
		
		public void onFinish(ITestContext context)
		{
			reports.flush();
			System.out.println("suite level execution completed");
		}
}
	
	
