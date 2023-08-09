package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(xpath="//img[contains(@title,'Cr')]") private WebElement addOrgIcon;

	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void addOrgIconClick() {
		addOrgIcon.click();
	}
	

}
