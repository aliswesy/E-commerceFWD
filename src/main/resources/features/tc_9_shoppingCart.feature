@regression
Feature: user should be able to add items to shopping cart

  Background: user login
    Given user is logged in "test@test.com" and "123123"
    And select "Computers" or "Notebooks"

  Scenario: user add product to shopping cart
    When user clicks on ADD TO CART
    Then item is added to cart and display message appear