@smoke
Feature: F11_addToCart | Logged user could add different products to Shopping cart

  Scenario: user add products to cart
    Given user can select a product
    When user can add product to shipping cart
    And product added to cart successfully

  Scenario: user edit shopping cart
    Given user open shopping cart
    When User can change product quantity in shipping cart
    Then User can delete product from shipping cart