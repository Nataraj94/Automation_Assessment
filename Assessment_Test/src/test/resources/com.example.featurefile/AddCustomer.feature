Feature: To validate the Add new customer functionality

  @Add
  Scenario: User Add a new Customer with valid information

    Given User navigates to customer page
    When user clicks the ADD New Button
    And user enter the valid customer information
    And user click the save button
    Then user validate the successful message

  @Add
  Scenario: User creates an account without filling mandatory fields

    Given User navigates to customer page
    When user clicks the ADD New Button
    And user enter the customer information without mandatory field
    And user click the save button
    Then User should get proper warning messages for every mandatory field

  @Add
  Scenario: User try to creates a duplicate account
    Given User navigates to customer page
    When user clicks the ADD New Button
    And user enter the duplicate customer information
    And user click the save button
    Then User should get a proper warning about duplicate email

  @Add
  Scenario: User creates an account without filling any details
    Given User navigates to customer page
    When user clicks the ADD New Button
    And User don't enter any details into fields
    And user click the save button
    Then User should verify get proper warning messages