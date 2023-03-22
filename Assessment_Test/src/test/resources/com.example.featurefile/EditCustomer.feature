Feature: To validate the edit customer functionality

  @Edit
  Scenario: User Select the registered Customer and edit user information

    Given User navigates to customer page
    When user search the registered customer with valid information
    And user select the customer and click edit button
    And user edit the valid customer information
    And user click the save & continue edit button
    Then user validate the successful edit message

  @Edit
  Scenario: User validate the change password in edit page

    Given User navigates to customer page
    When user select the customer and click edit button
    And user enters the new password and click change password button
    Then user validate the change password successful message


  @Edit
  Scenario: User validate edit customer role information

    Given User navigates to customer page
    When user select the customer and click edit button
    And user edit and save the customer roles information without selecting roles
    And user click the save & continue edit button
    Then user validate the edit customer role error message

  @Edit
  Scenario: User validate with duplicate user information in edit page

    Given User navigates to customer page
    When user select the customer and click edit button
    And user enters the duplicate password customer information
    Then user validate invalid error message in edit customer

  @Edit
  Scenario: User validate with invalid email

    Given User navigates to customer page
    When user select the customer and click edit button
    When user enters invalid email
    Then user Validate the error message for invalid email



