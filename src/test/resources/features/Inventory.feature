@inventory
Feature: Inventory
Background:
  Given User want to "Login to the SauceDemo website"
  When User fills username field with "standard_user"
  And Fills password field with "secret_sauce"
  And Clicks on login button
  Then User should be navigated to saucedemo homepage

  Scenario Outline: Checking inventory "<name>" filter
    Given User is in SauceDemo homepage
    When User chooses "<filter>" filter
    Then User should see all products according to "<name>" filter

    Examples:
      | name              | filter |
      | A to Z            | az     |
      | Z to A            | za     |
      | Price low to high | lohi   |
      | Price high to low | hilo   |

 Scenario: Checking basket number icon after we add item to basket
   Given User is in SauceDemo homepage
   When User adds as many products as he wants to the basket
   Then User should see basket icon number correctly

  Scenario: Adding item to the inventory
      Given User is in SauceDemo homepage
      When User clicks add to the card button for any item
      And Clicks to basket button
      Then User should see that item in the basket

  Scenario: Adding item to the inventory and check item after logout and login
    Given User is in SauceDemo homepage
    When User clicks add to the card button for any item
    And Clicks menu button
    And Clicks logout btn
    And User fills username field with "standard_user"
    And Fills password field with "secret_sauce"
    And Clicks on login button
    And Clicks to basket button
    Then User should see that item in the basket


  Scenario: Deleting item from the inventory
    Given User is in SauceDemo homepage
    When User clicks add to the card button for any item
    And Clicks to basket button
    And Clicks to delete button
    Then Item in the basket should be deleted