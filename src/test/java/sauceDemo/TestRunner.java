package sauceDemo;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import sauceDemo.utils.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        tags = "",
        plugin = {"rerun:target/failedrerun.txt", "pretty", "json:target/Cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void afterMethod() {
        CreateReport.make("target");
    }
}