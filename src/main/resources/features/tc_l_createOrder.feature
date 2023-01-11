@regression
Feature: user should be able to create order

  Background: user login
    Given user is logged in "test@test.com" and "123123"
    And select "Electronics" or "Cell-phones"

  Scenario: user add product to compare list
    When user clicks on ADD TO CART
    And goes to the shopping cart
    And press on agree to terms and press checkout
    And enter Billing address data
    And select shipping method
    And select payment method
    And confirm payment info method
    And confirm order
    Then confirmation message appear