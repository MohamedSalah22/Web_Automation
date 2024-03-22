Feature: Test Manage User Functionality


  Scenario: Manage_User Function
    Given I Navigate to URL
    When I Enter Valid user Name and Password
    And I Click on Login button
    And I Click on Admin Tab
    And I Get Count of Records
    And I Click on Add button
    And I Fill Mandatory Information
    And I Back to Users Grid
    Then Verify Users added Successfully
    When I Search For User
    And I Click on Delete
    Then Verify Number of Users decreased Successfully