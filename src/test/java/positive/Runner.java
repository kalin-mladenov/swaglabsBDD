package positive;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
    features = "src/test/resources")
public class Runner extends AbstractTestNGCucumberTests {
}
