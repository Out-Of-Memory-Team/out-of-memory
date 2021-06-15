Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page


  Scenario: Check Login is unsuccessful with invalid credentials
    Given user is on login page
    When user enters invalid username and password
    And clicks on login button
    Then user gets an error