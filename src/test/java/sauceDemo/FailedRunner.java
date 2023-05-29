package sauceDemo;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import sauceDemo.utils.CreateReport;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/failedrerun.txt"},
        plugin = {"html:target/cucumber/report-failed.html"})
public class FailedRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void afterMethod() {
        CreateReport.make("target");
    }
}
