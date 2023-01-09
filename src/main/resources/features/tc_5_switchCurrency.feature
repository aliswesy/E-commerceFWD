@regression
Feature: User should be able to switch currencies

  Background: user login
    Given user is logged in "test@test.com" and "123123"

  Scenario: user switch between currencies US-Euro
    When user click on currency bar
    And choose different currency
    Then currency will change