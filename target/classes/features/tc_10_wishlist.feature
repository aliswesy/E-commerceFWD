@regression
Feature: user should be able to add items to wishlist

  Background: user login
#    Given user is logged in "test@test.com" and "123123"
    And select "Electronics" or "Cell-phones"

  Scenario: user add product to wishlist
    When user clicks on wishlist button
    And goes to wishlist page
    Then item is added to wishlist