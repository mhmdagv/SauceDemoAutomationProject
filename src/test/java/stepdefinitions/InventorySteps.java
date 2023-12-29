package stepdefinitions;

import elements.InventoryPom;
import io.cucumber.java.en.When;

public class InventorySteps extends BaseMethods {
    InventoryPom inventoryPom;
    {
        inventoryPom = InventoryPom.getInstance();
    }


    @When("User clicks {string} item")
    public void userClicksItem(String text) throws InterruptedException {
        searchInsideDiv(inventoryPom.getInventoryItemNames() , text).click();
    }
}
