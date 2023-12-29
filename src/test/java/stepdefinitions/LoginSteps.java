package stepdefinitions;

import elements.LoginPom;
import enums.ExpectedConditionType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static enums.ExpectedConditionType.*;

public class LoginSteps extends BaseMethods{

    LoginPom loginPom;
    {
        loginPom = LoginPom.getInstance();
    }

    @When("User fills username field with {string}")
    public void userFillsUsernameFieldWith(String username) {
        explicitWait(loginPom.getUsernameInput(), VISIBLE, 30);
       getElement(loginPom.getUsernameInput()).sendKeys(username);
    }


    @And("Fills password field with {string}")
    public void fillsPasswordFieldWith(String password) {
        driver.findElement(loginPom.getPasswordInput()).sendKeys(password);
    }

    @And("Clicks on login button")
    public void clicksOnLoginButton() {
       driver.findElement(loginPom.getLoginBtn()).click();
    }

    @Then("User should be navigated to saucedemo homepage")
    public void userShouldBeNavigatedToSaucedemoHomepage() {
        Assert.assertEquals((driver.findElement(loginPom.getHomepageHeader())).getText(), "Swag Labs");
    }

    @Then("{string} input error message should be dispalyed")
    public void inputErrorMessageShouldBeDispalyed(String expectedError) {
        Assert.assertEquals(driver.findElement(loginPom.getLoginInputError()).getText() , expectedError);
    }



}
