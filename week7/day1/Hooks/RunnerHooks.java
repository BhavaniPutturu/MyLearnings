package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features={"src/test/java/features"},
glue={"stepdefinition", "HooksImplementation"},
publish=true)
public class RunnerHooks extends AbstractTestNGCucumberTests {
	
}
