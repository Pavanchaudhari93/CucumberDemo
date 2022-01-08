package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	public WebDriver driver;
	public LoginPage LP;
	
	@Given("user launch the crome browser")
	public void user_launch_the_crome_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/pavanchaudhari/Downloads/chromedriver");
		
		driver = new ChromeDriver();
		LP=new LoginPage(driver);
	}

	@When("user enter URL {string}")
	public void user_enter_URL(String url) {
	    driver.get(url);
	}

	@When("User enter valid Email as {string} and password as {string}")
	public void user_enter_valid_Email_as_and_password_as(String email, String password) {
	  LP.EMAIL(email);
	  LP.PASSWORD(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
	    LP.LOGIN();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(string, driver.getTitle());
			
		}
	   
	}

	@When("User click on logout button")
	public void user_click_on_logout_button() {
		LP.LOGOUT();
	    
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	    
	}



}
