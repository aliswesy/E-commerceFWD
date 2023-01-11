@regression
Feature: user could search for products

  Background: user login
    Given user is logged in "test@test.com" and "123123"

  Scenario Outline: user could search for products name
    When user goes to search bar and enters "<name>"
    And user clicks on search
    Then search result will appear
    But search word can't be less than 3 letters
  Examples:
    |name|
    |phone|
    |lap|
#
#  Scenario Outline: user could search for products sku
#    When user goes to search bar and enters "<sku>"
#    And user clicks on search
#    Then search result will appear
#    Examples:
#    |sku|
#    |M8_HTC_5L|
#    |COMP_CUST|