Feature: Let's order something from SWAGLABS



  Scenario: As an user I want to log in SWAGLABS page
    Given I'm on "https://www.saucedemo.com/" page
    When  I enter "standard_user" as username and "secret_sauce" as password
    And   I click on LOGIN button
    Then  I see "PRODUCTS" page header

  Scenario: As an user I want to add Sause Labs Backpack into Cart
    Given I'm on "https://www.saucedemo.com/" page
    When  I enter "standard_user" as username and "secret_sauce" as password
    And   I click on LOGIN button
    And   I click on ADD TO CART button for Sause Labs Backpack
    And   I click on cart icon
    Then  I see "Sauce Labs Backpack" in Cart

  Scenario: As an user I want to checkout from Cart
    Given I'm on "https://www.saucedemo.com/" page
    When  I enter "standard_user" as username and "secret_sauce" as password
    And   I click on LOGIN button
    And   I click on ADD TO CART button for Sause Labs Backpack
    And   I click on cart icon
    And   I click on CHECKOUT button
    Then  The "CHECKOUT: YOUR INFORMATION" page is loaded

  Scenario Outline: As an user I want to enter information details as data driven test in CHECKOUT page
    Given I'm on "https://www.saucedemo.com/" page
    When  I enter "standard_user" as username and "secret_sauce" as password
    And   I click on LOGIN button
    And   I click on ADD TO CART button for Sause Labs Backpack
    And   I click on cart icon
    And   I click on CHECKOUT button
    And   I enter "Kalin" for First Name, "Mladenov" for Last Name and "<post code>" for Zip Postal Code
    And   I click CONTINUE button
    Then  I can see "<expected text>" header
  Examples:
    |post code|expected text     |
    |111111111|CHECKOUT: OVERVIEW|
    |222222222|CHECKOUT: OVERVIEW|
    |333333333|CHECKOUT: OVERVIEW|
    |444444444|...               |
    |         |CHECKOUT: OVERVIEW|



  Scenario: As an user I want to complete order in SWAGLABS page
    Given I'm on "https://www.saucedemo.com/" page
    When  I enter "standard_user" as username and "secret_sauce" as password
    And   I click on LOGIN button
    And   I click on ADD TO CART button for Sause Labs Backpack
    And   I click on cart icon
    And   I click on CHECKOUT button
    And   I enter "Kalin" for First Name, "Mladenov" for Last Name and "5555" for Zip Postal Code
    And   I click CONTINUE button
    And   I click FINISH button
    Then  I see "THANK YOU FOR YOUR ORDER"

