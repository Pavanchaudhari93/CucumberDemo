package StepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.Searchcustomerpage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends Baseclass{
	
	@Before
	public void setup() throws IOException {
		
		
		logger=Logger.getLogger("nopCommerce");  //Added logger
		PropertyConfigurator.configure("/Users/pavanchaudhari/eclipse-workspace/CucumberDemo/log4j.properties");
		
//		reading properties
		configprop=new Properties();
		FileInputStream configpropfile=new FileInputStream("/Users/pavanchaudhari/eclipse-workspace/CucumberDemo/config.properties");
		configprop.load(configpropfile);
		
		String br=configprop.getProperty("browser");
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath") );
			driver = new ChromeDriver();
			
		}
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxpath") );
			driver = new FirefoxDriver();
			
		}
		else if(br.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver",configprop.getProperty("iepath") );
			driver = new InternetExplorerDriver();
			
		}
		
		logger.info("*****Launching Browser*******");
		
	}
	
	
	@Given("user launch the crome browser")
	public void user_launch_the_crome_browser() {
		
		LP=new LoginPage(driver);
	   
	}

	@When("user enter URL {string}")
	public void user_enter_URL(String url) {
		logger.info("*****Launching URL*******");
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enter valid Email as {string} and password as {string}")
	public void user_enter_valid_Email_as_and_password_as(String email, String password) {
		logger.info("*****providing logging details*******");
	  LP.EMAIL(email);
	  LP.PASSWORD(password);
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		logger.info("*****starting logging*******");
	    LP.LOGIN();
	    Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("*****Logginng passed*******");
			Assert.assertTrue(false);
		}else {
			logger.info("*****Logginng Failed*******");
			Assert.assertEquals(string, driver.getTitle());
			
		}
		Thread.sleep(3000);
	   
	}

	@When("User click on logout button")
	public void user_click_on_logout_button() {
		logger.info("*****Logging out*******");
		LP.LOGOUT();
	    
	}

	@Then("close the browser")
	public void close_the_browser() {
		logger.info("*****losing browser*******");
		driver.close();
	    
	}
	
//	Add new Customer feature steps..........................
	
	@When("user click on Customers menu")
	public void user_click_on_Customers_menu() throws InterruptedException {
		logger.info("*****searching customer by email*******");
		AC=new AddCustomerPage(driver);
		Thread.sleep(3000);
	    AC.clickOnCustomersMenu();
	}

	@When("user click on Customers")
	public void user_click_on_Customers() throws InterruptedException {
		Thread.sleep(3000);
	   AC.clickOnCustomers();
	}

	@When("user click on Add new")
	public void user_click_on_Add_new() throws InterruptedException {
		Thread.sleep(3000);
	   AC.clickOnAddnew();
	   Thread.sleep(3000);
	}

	@Then("user can view Add new Customer page")
	public void user_can_view_Add_new_Customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	    
	}

	@When("user enter customers info")
	public void user_enter_customers_info() throws InterruptedException {
	    AC.AddEmail("chaudhar.pavan@gmail.com");
	    AC.AdddPassword("PAvan@12");
	    AC.AddFirstName("pavan");
	    AC.AddLastName("chaudhari");
	    AC.Gender("Male");
	    AC.DOB("9/16/1993"); //format d/m/y
	    AC.Companyname("Wipro");
	    AC.IstaxExemted("Yes");
	    AC.SetCustomerRole("Vendors");
//	    AC.setManagerOfVendor("Vendor 2");
//	    AC.AdminComment("Good company for testing......");
	}

	@When("user click on Save button")
	public void user_click_on_Save_button() {
	    AC.save();
	}

	@Then("user can view the message {string}")
	public void user_can_view_the_message(String msg ) {
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	     
	}

//	Search Customer by Email feature steps..........................


	@When("Enter Customer Details")
	public void enter_Customer_Details() throws InterruptedException {
		SC=new Searchcustomerpage(driver);
		SC.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		SC.clickonsearch();
		Thread.sleep(3000);
	}

	@Then("user should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
		
		boolean status=SC.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		System.out.println(status);
		Assert.assertEquals(true, status);
	    
	}
	
//	Search Customer By Name feature steps..........................
	
	@When("Enter Customer FirstName")
	public void enter_Customer_FirstName() throws InterruptedException {
		SC.Fname("Victoria");	   
	}

	@When("Enter Customer LastName")
	public void enter_Customer_LastName() throws InterruptedException {
		SC.Lname("Terces");
	}

	@Then("user should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
		boolean status=SC.searchCustomerByName("Victoria Terces");
		System.out.println(status);
		Assert.assertEquals(true, status);
	}
	

}
