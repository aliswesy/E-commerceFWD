@regression
Feature: user could filter with color

  Background: user login
    Given user is logged in "test@test.com" and "123123"
    And select "Computers" or "Notebooks"

  Scenario: user could select a tag
    When user press on a tag "computer"
    Then items with the same tag "computer" will appear