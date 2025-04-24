package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/featuresSF"},
	glue="stepdefinition",
	publish=true)
public class SFRunner extends AbstractTestNGCucumberTests {

}
