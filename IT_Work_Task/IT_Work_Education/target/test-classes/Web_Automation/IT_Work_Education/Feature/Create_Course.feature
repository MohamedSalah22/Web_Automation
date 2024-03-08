Feature: Test Create Course Functionality


  Scenario: Create_Course Function
    Given I Navigate to URL
    When I Enter Valid user Name and Password
    And I Click on Login button
    And I Click on Courses Icon
    And I Click on Add Course button
    And I Fill Mandatory Information
    And I Back to Courses Grid
    Then Verify Course Created Successfully