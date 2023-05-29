package sauceDemo.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sauceDemo.elements.GeneralPOM;

import javax.swing.*;
import java.util.List;

import static sauceDemo.elements.GeneralPOM.*;
import static sauceDemo.elements.InventoryPOM.*;
import static sauceDemo.elements.LoginPOM.logoutBtn;
import static sauceDemo.enums.ExpectedConditionType.VISIBLE;

public class InventorySteps extends BaseMethods{
    private String inventoryElementName;
    private int addedItemsCount;
    @Given("User is in SauceDemo homepage")
    public void userIsInSauceDemoHomepage() {
    }

    @When("User chooses {string} filter")
    public void weChooseAToZFilter(String filter) {
        Select dropdown = new Select(te(filterDropdown));
        dropdown.selectByValue(filter);
    }

    @Then("User should see all products according to {string} filter")
    public void userShouldSeeAllProductsAccordingToFilter(String str1) {
      List<WebElement> list = null;
      boolean flag = true;
      switch(str1){
          case "A to Z":{
              list = tes(inventoryElementsName);
              for(int i = 1 ; i < list.size(); i++){
                  String text1 = list.get(i-1).getText().replaceAll("[^a-zA-Z]", "").toLowerCase();;
                  String text2 = list.get(i).getText().replaceAll("[^a-zA-Z]", "").toLowerCase();
                  int size = Math.min(text1.length(), text2.length());
                  for(int j = 0 ; j<size; j++){
                      if(text1.charAt(j) == text2.charAt(j)) continue;
                      if(text1.charAt(j) < text2.charAt(j)) break;
                      if(text1.charAt(j) > text2.charAt(j)){
                          flag = false;
                          break;
                      }
                  }
                  if(!flag) break;
              }
              break;
          }
          case "Z to A":{
              list = tes(inventoryElementsName);
              for(int i = 1 ; i < list.size(); i++){
                  String text1 = list.get(i-1).getText().replaceAll("[^a-zA-Z]", "").toLowerCase();;
                  String text2 = list.get(i).getText().replaceAll("[^a-zA-Z]", "").toLowerCase();
                  int size = Math.min(text1.length(), text2.length());
                  for(int j = 0 ; j<size; j++){
                      if(text1.charAt(j) == text2.charAt(j)) continue;
                      if(text1.charAt(j) > text2.charAt(j)) break;
                      if(text1.charAt(j) < text2.charAt(j)){
                          flag = false;
                          break;
                      }
                  }
                  if(!flag) break;
          }
              break;
      }
          case "Price low to high":{
              list = tes(inventoryElementsPrices);
              for(int i = 1 ; i < list.size(); i++){
                  double amount1 = Double.parseDouble(list.get(i-1).getText().replace("$" , ""));
                  double amount2 = Double.parseDouble(list.get(i).getText().replace("$" , ""));
                  if(amount2<amount1){
                      flag = false;
                      break;
                  }
              }
              break;
          }
          case "Price high to low":{
              list = tes(inventoryElementsPrices);
              for(int i = 1 ; i < list.size(); i++){
                  double amount1 = Double.parseDouble(list.get(i-1).getText().replace("$" , ""));
                  double amount2 = Double.parseDouble(list.get(i).getText().replace("$" , ""));
                  if(amount2>amount1){
                      flag = false;
                      break;
                  }
              }
              break;
          }
      }
        Assert.assertTrue(flag);
    }

    @When("User clicks add to the card button for any item")
    public void userClicksAddToTheCardButtonForAnyItem() {
        List<WebElement> list = tes(inventoryElementsAddBtn);
        int num = generateRandNum(0,list.size()-1);
        list.get(num).click();
        inventoryElementName = tes(inventoryElementsName).get(num).getText();
    }

    @And("Clicks to basket button")
    public void clicksToBasketButton() {
        te(basketBtn).click();
    }

    @Then("User should see that item in the basket")
    public void userShouldSeeThatItemInTheBasket() {
        Assert.assertEquals(inventoryElementName , te(inventoryElementsName).getText());
    }

    @And("Clicks menu button")
    public void weClickMenuButton() throws InterruptedException {
        te(menuBtn).click();
        explicitWait(logoutBtn , VISIBLE , 5);
    }

    @And("Clicks logout btn")
    public void weClickLogoutBtn() {
        clickElementLocation(logoutBtn);
    }

    @When("User adds as many products as he wants to the basket")
    public void userAddsAsManyProductsAsHeWantsToTheBasket() throws InterruptedException {
        List<WebElement> list = tes(inventoryElementsAddBtn);
        System.out.println(list.size());
        int size = generateRandNum(1, list.size());
        for(int i = 0 ; i < size; i++ ){
            list.get(i).click();
            addedItemsCount++;
        }
        System.out.println(size + " " + addedItemsCount);
    }

    @Then("User should see basket icon number correctly")
    public void userShouldSeeBasketIconNumberCorrectly() {
        Assert.assertEquals(addedItemsCount , Integer.parseInt(te(basketNumberIcon).getText()));
    }

    @And("Clicks to delete button")
    public void clicksToDeleteButton() {
        te(basketRemoveBtn).click();
    }

    @Then("Item in the basket should be deleted")
    public void itemInTheBasketShouldBeDeleted() {
        Assert.assertTrue(tes(inventoryElementsName).isEmpty());
    }

}
