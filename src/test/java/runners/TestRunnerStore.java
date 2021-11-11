package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/java/features/Store.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:reports/Swagger-StoreReports.html"},
        publish = false,
        monochrome = true,
        dryRun = false
)

@Test
public class TestRunnerStore extends AbstractTestNGCucumberTests {
}
