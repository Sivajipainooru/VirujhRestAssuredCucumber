package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/placeOrder.feature",plugin="json:target/jsonReports/cucumber-report.json",glue={"stepDefinition"},dryRun=false,
monochrome=true,tags= {"@AddPlace"})
public class TestRunner {

}
