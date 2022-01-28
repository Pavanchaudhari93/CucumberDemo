package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By CustomerMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customer')]");
	By Customers = By.xpath("//li[@class='nav-item']//p[contains(text(),'Customers')]");
	By Addnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By Email = By.xpath("//input[@id='Email']");
	By Password = By.xpath("//input[@id='Password']");
	By FirstName = By.xpath("//input[@id='FirstName']");
	By LastName = By.xpath("//input[@id='LastName']");
	
	By MGender = By.xpath("//input[@id='Gender_Male']");
	By FGender = By.xpath("//input[@id='Gender_Female']");
	
	By DOB = By.xpath("//input[@id='DateOfBirth']");

	By CompanyName = By.xpath("//input[@id='Company']");
	
	By IsTaxExemted = By.xpath("//input[@id='IsTaxExempt']");
	
	By CustomerRole = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By Administrators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By ForumModerators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By Guests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By Registers = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By Vendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	
	By ManagerOfVendor = By.xpath("//Select[@id='VendorId']");
	
	By AdminComment = By.xpath("//textarea[@id='AdminComment']");
	
	By save = By.xpath("//button[@name='save']");
	
	
//	Action Methods
	
	public void clickOnCustomersMenu() {
		driver.findElement(CustomerMenu).click();
	}
	
	public void clickOnCustomers() {
		driver.findElement(Customers).click();
	}
	
	public void clickOnAddnew() {
		driver.findElement(Addnew).click();
	}

	public void AddEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	
	public void AdddPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	
	public void AddFirstName(String fname) {
		driver.findElement(FirstName).sendKeys(fname);
	}
	
	public void AddLastName(String lname) {
		driver.findElement(LastName).sendKeys(lname);
	}
	public void Gender(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(MGender).click();
		}
		else if(gender.equals("Female")) {
			driver.findElement(FGender);
		}
		else {
			driver.findElement(MGender).click();
		}
	}
	
	public void DOB(String dob) {
		driver.findElement(DOB).sendKeys(dob);
	}
	
	public void Companyname(String cname) {
		driver.findElement(CompanyName).sendKeys(cname);
	}
	
	public void IstaxExemted(String yes) {
		if(yes.equals("Yes")) {
			driver.findElement(IsTaxExemted).click();
		}
		else {
			System.out.println("Customer not Exempted from Tax");
		}
	}
	
	public void SetCustomerRole(String role) throws InterruptedException {
		driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
//		if(!role.equals("Vendor"))
//		{
//		driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]")).clear();
//		Thread.sleep(3000);
//		}
		driver.findElement(CustomerRole).click();
		Thread.sleep(3000);
		WebElement setrole;
		 
		if(role.equals("Administrators")) {
			setrole = driver.findElement(Administrators);
		}
		else if(role.equals("Forum Moderators")) {
			setrole = driver.findElement(ForumModerators);
		}
		else if(role.equals("Guests")) {
			setrole = driver.findElement(Guests);
		}
		else if(role.equals("Registered")) {
			setrole = driver.findElement(Registers);
		}
		else if(role.equals("Vendors")) {
			setrole = driver.findElement(Vendors);
		}
		else
		{
			setrole = driver.findElement(Guests);
		}
		setrole.click();
		
//		By javascript
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click():", setrole);
	}
	
	public void setManagerOfVendor(String value) {
		
		Select select = new Select(driver.findElement(ManagerOfVendor));
		select.selectByValue(value);
	}
	
	public void AdminComment(String comment) {
		driver.findElement(AdminComment).sendKeys(comment);
	}
	
	public void save() {
		driver.findElement(save).click();
	}
	
	
}
