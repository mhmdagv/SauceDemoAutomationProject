package sauceDemo.stepDefinitions;

import org.openqa.selenium.interactions.Actions;
import sauceDemo.enums.ExpectedConditionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceDemo.driverSession.CreateDriverSession;

import java.time.Duration;
import java.util.List;

public abstract class BaseMethods {

    protected WebDriver driver;
    public BaseMethods(){
        this.driver = CreateDriverSession.driver;
    }

    protected JavascriptExecutor getJsExc(){
        return (JavascriptExecutor) driver;
    }
    protected WebElement te(By element){
        return driver.findElement(element);
    }
    protected List<WebElement> tes(By element){
        return driver.findElements(element);
    }
    protected Actions actions(){
        return new Actions(driver);
    }
    protected int getWindowHeight(){
        return ((Number) getJsExc().executeScript("return window.innerHeight")).intValue();
    }
    protected int getWindowWidth(){
        return ((Number) getJsExc().executeScript("return window.innerWidth")).intValue();
    }
    protected void implicitWait(int t){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
    }
    protected void explicitWait(By element, ExpectedConditionType type, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (type) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                break;
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case PRESENCE:
                wait.until(ExpectedConditions.presenceOfElementLocated(element));
                break;
            default:
                throw new IllegalArgumentException("Unexpected saucedemo.ExpectedConditionType: " + type);
        }
    }

    protected void scroll(By element){
        getJsExc().executeScript("arguments[0].scrollIntoView(true);", te(element));
    }

    protected int generateRandNum(int min , int max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    protected void clickElementLocation(By element){
        actions().moveToElement(driver.findElement(element)).click().perform();
    }
}
