@smoke
Feature: F01_register | User could register with valid data

  Scenario: User should be able to register with valid username and password
    Given user go to register page
    When user enter a valid data
    And user press on register button
    Then user register to the system successfully
    And user logout