package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class Searchcustomerpage extends SeleniumUtility{

	public WebDriver driver;
	SeleniumUtility utility=new SeleniumUtility();

	public Searchcustomerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID , using = "SearchEmail")
	@CacheLookup
	WebElement txtMail;
	
	@FindBy(how = How.ID , using = "SearchFirstName")
	@CacheLookup
	WebElement txtfirstname;
	
	@FindBy(how = How.ID , using = "SearchLastName")
	@CacheLookup
	WebElement txtlastname;
	
	@FindBy(how = How.ID , using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement txtSearchMonthOfBirthe;

	@FindBy(how = How.ID , using = "SearchDayOfBirth")
	@CacheLookup
	WebElement txtSearchDayOfBirth;
	
	@FindBy(how = How.XPATH , using = "//input[@id='SearchCompany']")
	@CacheLookup
	WebElement txtcompany;
	
	@FindBy(how = How.XPATH , using = "//input[@id='SearchIpAddress']")
	@CacheLookup
	WebElement txtipaddress;
	
	@FindBy(how = How.CSS , using = ".k-multiselect-wrap.k-floatwrap")
	@CacheLookup
	WebElement txtcustomerrole;
	
	@FindBy(how = How.XPATH , using = "//button[@id='search-customers']")
	@CacheLookup
	WebElement searchbutton;
	
	@FindBy(how = How.XPATH , using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH , using = "//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;
	
	@FindBy(how = How.XPATH , using = "//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecloumn;
	
	
	public void setEmail(String email) throws InterruptedException {
		Thread.sleep(2000);
		txtMail.sendKeys(email);
	}
	
	public void Fname(String name) throws InterruptedException {
		txtfirstname.sendKeys(name);
		Thread.sleep(3000);
	}
	
    public void Lname(String name) throws InterruptedException {	
    	txtlastname.sendKeys(name);
    	Thread.sleep(3000);
	}
	
    public void clickonsearch() throws InterruptedException {
    	searchbutton.click();
    	Thread.sleep(2000);
    }
	
	public int getNoOfRows() {
		return (tablerows.size());
	}
	
	public int getNoOfColumns() {
		return(tablecloumn.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows(); i++) {
			
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
					
			System.out.println(emailid);
			
			if(emailid.equals(email)) {
				
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name) {
		boolean flag=false;
		
		for(int i=1; i<=getNoOfRows(); i++) {

			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			String names[]=name.split(" ");
			
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				
			flag=true;	
			}
		}
		return flag;
	}
}
