package sauceDemo;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import sauceDemo.utils.*;

@CucumberOptions(
        features = {"classpath:features"},
        tags = "",
        plugin = {"rerun:target/failedrerun.txt", "pretty", "json:target/Cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    @AfterSuite
    public static void afterMethod() {
        CreateReport.make("target");
    }
}