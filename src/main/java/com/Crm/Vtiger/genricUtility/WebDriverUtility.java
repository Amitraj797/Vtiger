package com.Crm.Vtiger.genricUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximize the window.
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window.
	 * @param driver
	 */
	
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();

	}
	
	/**
	 * This method will wait the webpage for specific period of time.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitwaitDuration));
	}
	
	/**
	 * This method will wait the webpage for specific period of time.
	 * @param driver
	 * @param element
	 */
	public void visiblityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void alertPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void titleContains(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This methos is used to handle the Dropdown
	 * @param dropdown
	 * @param index
	 */
	
	public void dropdown(WebElement dropdown, int index)
	{
		Select s=new Select (dropdown);
		s.selectByIndex(index);
	}
	
	public void dropdown(WebElement dropdown, String text)
	{
		Select s=new Select (dropdown);
		s.selectByVisibleText(text);;
	}
	
	public void dropdownByValue(WebElement dropdown,String value )
	{
		Select s=new Select (dropdown);
		s.selectByValue(value);
	}
	
	/**
	 * These methods are used to handle Mouse actions
	 * @param driver
	 * @param target
	 */
	
	public void click(WebDriver driver,WebElement target)
	{
		Actions act=new Actions(driver);
		act.click().perform();
		act.click(target);
	}
	
	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void moveToElement(WebDriver driver,WebElement Wb)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Wb).perform();	
	}
	
	/**
	 * This method is use to handle Scroll action
	 * @param driver
	 * @param element
	 */
	public void scrollThePageToElement(WebDriver driver,WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	/**
	 * This method is used to switch to different frame
	 * @param driver
	 * @param index
	 */
	
	public void frame (WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void frame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void frame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	
	public void parentFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * By using this method to handle Alert Popup
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void getTextFromAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to take Screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String screenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime local=LocalDateTime.now();
		local.toString().replace("-", "_").replace(":", "_");
		File trg=new File("/Screenshot/"+screenshotName+".png");
		Files.copy(src, trg);
		return trg.getAbsolutePath();//Extent report
	}
}
