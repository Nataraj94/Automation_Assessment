Feature: To validate the delete customer functionality


  Scenario: User Select the registered Customer and edit user information

    Given User navigates to customer page
    When user search the registered customer with valid information
    And user select the customer and click edit button
    And user click the delete option and clicks the delete button in alert
    Then user validate the alert message