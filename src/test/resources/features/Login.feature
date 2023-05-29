@login
Feature: Login
  Scenario Outline: Successful login to SauceDemo website
    Given User want to "Login to the SauceDemo website"
    When User fills username field with "<username>"
    And Fills password field with "<password>"
    And Clicks on login button
    Then User should be navigated to saucedemo homepage
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |

Scenario Outline: Negative("<scenario>") login to SauceDemo website
  Given User want to "Login to the SauceDemo website"
  When User fills username field with "<username>"
  And Fills password field with "<password>"
  And Clicks on login button
  Then "<error>" input error message should be dispalyed
  Examples:
    | scenario                                  | username      | password     | error                                                                     |
    | empty username and password               |               |              | Epic sadface: Username is required                                        |
    | empty password                            | standard_user |              | Epic sadface: Password is required                                        |
    | empty username                            |               | secret_sauce | Epic sadface: Username is required                                        |
    | correct username incorrect password       | standard_user | 1234         | Epic sadface: Username and password do not match any user in this service |
    | incorrect username correct password       | standart_user | secret_sauce | Epic sadface: Username and password do not match any user in this service |
    | incorrect username and incorrect password | standart_user | 1234         | Epic sadface: Username and password do not match any user in this service |

