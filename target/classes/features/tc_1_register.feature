@regression
Feature: user should be able to create a new account

  Scenario: user could register to website
    Given user open browser and goes to register page
    When user selects gender type
    And user enters "firstName" and "lastLame"
    And user choose date of birth
    And user enters email address "test@test.com"
    And user enters password fields "123123"
    And user press on register
    Then register message is displayed "Your registration completed"