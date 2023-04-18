package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/Customer.feature", 
		glue="stepDefinition", 
		dryRun=false,
		plugin= {"pretty", 
				"html:test-output"}
		)

public class TestRunner {
	
}
