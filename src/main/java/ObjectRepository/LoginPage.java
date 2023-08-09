package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//	Identify the WebElement and declare the element as private
	@FindBy(name="user_name") private WebElement usernameEdt;
	@FindBy(name="user_password") private WebElement passwordEdt;
	@FindBy(css="#submitButton") private WebElement submitBtn;


//	creating a constructor to initialize the WebElement
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//	Create generic method for script Optimization
	public void Login(String UN,String PW)
	{
		usernameEdt.sendKeys(UN);
		passwordEdt.sendKeys(PW);
		submitBtn.click();
	}
}
