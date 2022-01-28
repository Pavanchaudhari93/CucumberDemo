package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.Searchcustomerpage;

public class Baseclass {
	public WebDriver driver;
	public LoginPage LP;
	public AddCustomerPage AC;
	public Searchcustomerpage SC;
	public static Logger logger;
	public Properties configprop;
	
	 // created for generating random emailid
	
	public static String randomemailid() {
		String generaterandomemailid = RandomStringUtils.randomAlphabetic(5);
		return generaterandomemailid ;
	}

}
