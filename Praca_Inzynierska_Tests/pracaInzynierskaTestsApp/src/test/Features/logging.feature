@logging
Feature: Tests of logging

  Scenario: login and logout test
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    And User can logout

    Scenario: Register and login
      Given Reinstall configuration
      Given User is on main page
      Then User switch to register form
      And User enters register data and submit form with login "superSelenium@wp.pl" and password "pass123"
      Then User switch to login form
      And User enters login data and submit form with password "pass123" and login "superSelenium@wp.pl"
      Then User is on user page
      And User can logout



