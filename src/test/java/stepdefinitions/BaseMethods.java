package stepdefinitions;

import createdriversession.CucumberHook;
import enums.ExpectedConditionType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseMethods {


    WebDriverWait wait;
    private Actions actions;

    protected WebDriver driver;

    {
        driver = CucumberHook.driver;
    }

    protected Actions getActions(){
        if(actions == null){
            actions = new Actions(driver);
        }
        return actions;
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    protected int generateRandNum(int size){
        return 0;
    }

    protected void clickElementLocation(By locator){
      getActions().moveToElement(getElement(locator)).click().perform();
    }

    protected WebElement searchInsideDiv(By locator , String text){
        List<WebElement> elements = getElements(locator);
        for(WebElement element: elements){
            if(element.getText().contains(text)) return element;
        }
       throw new NoSuchElementException("There is no such text inside these elements");
    }

    protected void explicitWait(By locator , ExpectedConditionType expectedCondition , int time){
        wait = new WebDriverWait(driver , Duration.ofSeconds(time));
        switch(expectedCondition){
            case VISIBLE: {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            }
            case PRESENCE:{
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            }
            case INVISIBLE:{
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            }
            case CLICKABLE:{
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            }
            default: throw new IllegalArgumentException("Wrong expected condition");
        }
    }

}
