package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		
			features={"/Users/pavanchaudhari/eclipse-workspace/CucumberDemo/Feature/feature.feature"},
			
			glue={"StepDefination"},
			
			dryRun=true,
			
			plugin = {"html:target/cucumber-html-report"},
					
			monochrome = true,
			
			tags= {"@sanity,@regression"}
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
