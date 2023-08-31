package sauceDemo;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import sauceDemo.utils.CreateReport;

@CucumberOptions(features = {"@target/failedrerun.txt"},
        plugin = {"html:target/cucumber/report-failed.html"})
public class FailedRunner  {
    @AfterClass
    public static void afterMethod() {
        CreateReport.make("target");
    }
}
