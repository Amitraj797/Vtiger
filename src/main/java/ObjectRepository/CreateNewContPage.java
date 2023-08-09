package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContPage {

	@FindBy(name="lastname") private WebElement lastName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	
	public CreateNewContPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void cretCont(String lstName)
	{
		lastName.sendKeys(lstName);
		saveBtn.click();
	}
}
