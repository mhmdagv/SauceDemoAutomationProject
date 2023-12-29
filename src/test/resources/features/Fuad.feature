@inventory
Feature: Inventory
  Background:
    When User fills username field with "standard_user"
    And Fills password field with "secret_sauce"
    And Clicks on login button
    Then User should be navigated to saucedemo homepage

  Scenario Outline: Click SauceDemo bike light
    Given User want to "click saucedemo bike light"
    When User clicks "<itemName>" item

    Examples:
      | itemName                |
      | Sauce Labs Bike Light   |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |




