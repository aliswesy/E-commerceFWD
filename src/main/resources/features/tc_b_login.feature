@regression
Feature: User should be able to login to his account

  Scenario: user login with valid data
    Given user goes to login page
    When user enters data "test@test.com" and "123123"
    And user press on login
    Then user login successfully

  Scenario: user login with invalid data
    Given user goes to login page
    When user enters data "notTes@test.com" and "123123"
    And user press on login
    Then user login failed