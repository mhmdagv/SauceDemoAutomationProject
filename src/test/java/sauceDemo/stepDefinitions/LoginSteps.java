package sauceDemo.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static sauceDemo.elements.LoginPOM.*;
import static sauceDemo.enums.ExpectedConditionType.VISIBLE;

public class LoginSteps extends BaseMethods {

    @When("User fills username field with {string}")
    public void userFillsUsernameFieldWith(String username) {
        explicitWait(usernameInput , VISIBLE , 10);
        te(usernameInput).sendKeys(username);
    }


    @And("Fills password field with {string}")
    public void fillsPasswordFieldWith(String password) {
        te(passwordInput).sendKeys(password);
    }

    @And("Clicks on login button")
    public void clicksOnLoginButton() {
        te(loginBtn).click();
    }

    @Then("User should be navigated to saucedemo homepage")
    public void userShouldBeNavigatedToSaucedemoHomepage() {
        Assert.assertEquals(te(homepageHeader).getText(), "Swag Labs");
    }

    @Then("{string} input error message should be dispalyed")
    public void inputErrorMessageShouldBeDispalyed(String expectedError) {
        Assert.assertEquals(te(loginInputError).getText() , expectedError);
    }


}
