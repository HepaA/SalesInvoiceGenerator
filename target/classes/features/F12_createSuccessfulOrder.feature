@smoke
Feature:F_12 Create successful Order

  Scenario:
    Given go to shopping cart
    And accept the terms of service
    When click on check out button
    And Update address information
    Then confirm order
    And order completed successfully
