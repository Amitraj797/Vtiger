package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath="//img[@title='Create Contact...']") private WebElement addContIcon;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickContact()
	{
		addContIcon.click();
	}

}
