package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class LoginPage extends SeleniumUtility{
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement userEmail;
	
	@FindBy(id = "Password")
	WebElement userpwd;
	
	@FindBy(css = ".button-1.login-button")
	WebElement loginbutton;
	
	@FindBy (linkText="Logout") 
	WebElement logout;
		
	public void EMAIL(String email) {
		userEmail.clear();
		userEmail.sendKeys(email);
	}
	public void PASSWORD(String password) {
		userpwd.clear();
		userpwd.sendKeys(password);
	}
	public void LOGIN() {
		loginbutton.click();
	}
	public void LOGOUT() {
		logout.click();
	}
}

