package createdriversession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {
    public static WebDriver driver;


    @Before
    public void beforeScenario(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @After
    public void afterScenario(){
        driver.quit();
    }

}
