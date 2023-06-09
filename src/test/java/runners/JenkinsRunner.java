package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefs",
        tags = "@jenkins",
        plugin = {"pretty", "html:target/cucumber-smoke-report.html"}
)
public class JenkinsRunner {
}