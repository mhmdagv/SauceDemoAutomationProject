package sauceDemo.stepDefinitions;

import io.cucumber.java.en.Given;

public class GeneralSteps extends BaseMethods{

    @Given("User want to {string}")
    public void iWantTo(String arg0) {
        driver.get("https://www.saucedemo.com/");
    }

}
