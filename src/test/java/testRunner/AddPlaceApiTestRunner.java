package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="CucumberRestAssureProject/src/test/java/features/AddPlaceApi.feature",
glue="stepDefinition",dryRun=false)

public class AddPlaceApiTestRunner {

}
