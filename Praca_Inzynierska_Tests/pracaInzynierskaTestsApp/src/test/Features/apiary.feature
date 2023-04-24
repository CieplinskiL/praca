@apiary
Feature: Tests of apiary

  Scenario: Add and delete apiary
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User opens apiary creation form
    And User insert data and submit apiary creation form
    Then Apiary is created
    Then User deletes created apiary

    Scenario: Add apiary and add beehive
      Given Reinstall configuration
      Given User is on main page
      Then User switch to login form
      And User enters login data and submit form
      Then User is on user page
      Then User opens apiary creation form
      And User insert data and submit apiary creation form
      Then Apiary is created
      And User selects apiary selenium
      Then User opens beehive creation form
      Then User inserts data and creates beehive SeleniumBeehive
      Then User checks beehive data
      Then User adds food



  Scenario: Add apiary and Note
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User opens apiary creation form
    And User insert data and submit apiary creation form
    Then Apiary is created
    And User selects apiary selenium
    Then User adds Note



  Scenario: Add apiary and add beehive and add correct scales
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User opens apiary creation form
    And User insert data and submit apiary creation form
    Then Apiary is created
    And User selects apiary selenium
    Then User opens beehive creation form
    Then User inserts data and creates beehive SeleniumBeehive
    Then User checks beehive data
    Then User goes to Beehive details and add Scales api "3b942adf-a56a-469b-8bbe-5043cb17c701"



  Scenario: Add apiary and add beehive and add wrong scales
    Given Reinstall configuration
    Given User is on main page
    Then User switch to login form
    And User enters login data and submit form
    Then User is on user page
    Then User opens apiary creation form
    And User insert data and submit apiary creation form
    Then Apiary is created
    And User selects apiary selenium
    Then User opens beehive creation form
    Then User inserts data and creates beehive SeleniumBeehive
    Then User checks beehive data
    Then User goes to Beehive details and add Scales api "3-4-334WRONG2145-4124-241"
