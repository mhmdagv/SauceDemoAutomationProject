package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BaseSteps extends BaseMethods{

    @Given("User want to {string}")
    public void userWantTo(String arg0) throws InterruptedException {
        Thread.sleep(3000);
    }

}
