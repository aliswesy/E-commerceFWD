@regression
Feature: user should be able to reset his/her password

  Scenario: user will reset password throw the forget password
    Given user goes to reset password page
    When user enters his/her email "test@test.com"
    And press recover
    Then confirmation message is displayed