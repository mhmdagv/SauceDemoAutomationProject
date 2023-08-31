package sauceDemo.driverSession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CreateDriverSession {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driver.get();
    }

    @Before
    public void beforeScenario(){
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver" ,/* add your own chromedriver path*/ "/Users/agayevmr/Documents/Automation Testing/SauceDemoo/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver.set(ThreadGuard.protect(new ChromeDriver(chromeOptions)));
        getDriver().manage().window().maximize();
    }


    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", UUID.randomUUID().toString());
        }
        getDriver().quit();
    }

}
