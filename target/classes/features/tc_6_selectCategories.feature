@regression
Feature: user could select different Categories

  Background: user login
    Given user is logged in "test@test.com" and "123123"

  Scenario Outline: select sub-category
    When user hover over a "<category>"
    And select "<category>" or "<sub-category>"
    Then "<category>" or "<sub-category>" heading are displayed
  Examples:
    |category|sub-category|
    |Computers|Notebooks  |
    |Books    |           |