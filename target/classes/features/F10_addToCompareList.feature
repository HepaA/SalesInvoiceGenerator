@smoke
Feature:F10_AddToCompareList | Logged user could add different products to compare list

  Scenario:AddTo Compare List
    Given user select a product
    When user can add product to compare list
    Then product added to compare list successfully
