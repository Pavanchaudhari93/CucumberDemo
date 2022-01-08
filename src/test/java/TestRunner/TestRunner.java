package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		
			features={"/Users/pavanchaudhari/eclipse-workspace/CucumberDemo/Feature/feature.feature"},
			
			glue={"StepDefination"},
			
			plugin = {"html:target/cucumber-html-report"},
					
			monochrome = true
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
