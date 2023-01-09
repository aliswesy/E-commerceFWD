@regression
Feature: user could filter with color

  Background: user login
    Given user is logged in "test@test.com" and "123123"
    And select "Apparel" or "Shoes"

  Scenario: user filter shoes with color
    When user filter with color "Red"
    Then only "1" displayed items will appear