package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Crm.Vtiger.genricUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
//	Identify the WEbElement and declare the webelement as private
	
	@FindBy(linkText="Organizations") private WebElement orgLink;
	@FindBy(linkText="Contacts") private WebElement contLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement administrator;
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']") private WebElement signoutBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void orgClick()
	{
		orgLink.click();
	}
	
	public void ContClick()
	{
		contLink.click();
	}

	public void logout(WebDriver driver)
	{
		moveToElement(driver,administrator);
		signoutBtn.click();
	}
}
