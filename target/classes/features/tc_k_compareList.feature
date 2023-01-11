@regression
Feature: user should be able to add items to compare list

  Background: user login
    Given user is logged in "test@test.com" and "123123"
    And select "Electronics" or "Cell-phones"

  Scenario: user add product to compare list
    When user clicks on compare button
    Then item is added to compare list and display message appear