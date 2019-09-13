package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        tags = {"@Assessment"},
        format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"} ,
        glue = {"iLabProject"})

public class TestNGRunner extends AbstractTestNGCucumberTests {
}