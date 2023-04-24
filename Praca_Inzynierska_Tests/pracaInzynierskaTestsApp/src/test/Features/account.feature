@account
Feature: Tests of account

  Scenario: Go to account page
Given Reinstall configuration
Given User is on main page
Then User switch to login form
And User enters login data and submit form
Then User is on user page
Then User goes to account page
Then User Changes credentials
Then Send illness notification


  Scenario: Send illness notification from main page
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User goes to account page
    Then Send illness notification

  Scenario: Change Password
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User goes to account page
    Then ChangePassword to "passSelenium"
    And User can logout
    Then User switch to login form
    And User enters login data and submit form with password "passSelenium"
    Then User is on user page