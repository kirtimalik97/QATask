package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Pet.feature",
		glue = "stepdefinitions",
		plugin = { "pretty",
		"html:reports/Swagger-PetReports.html" },
		publish = false,
		monochrome = true,
		dryRun = false
)

@Test
public class TestRunnerPet extends AbstractTestNGCucumberTests {

	
}
