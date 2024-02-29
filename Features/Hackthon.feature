Feature: Identify New bikes

  Scenario: Getting the bikes data
    Given The user should be on the https://www.zigwheels.com website
    When user navigates to the New Bikes
    Then user clicks on the Upcomming Bikes
    And user the manaufacture dropdown and select Honda
    Then Extract the data of bikes less than four lacks
    
 
	Scenario: Getting the cars data
    Given The user should be on the zigwheels.com website Home page
    When user navigates to the Used cars dropdown
    Then user clicks on the Chennai
    And  Extract the data under the popular models
    
   
  Scenario: Verifying the login
    Given The user should be on the zigwheels.com  Home page
    When user click on the login tab
    Then user clicks on the google
    And  Enters the invalid details
    And Extract the error information
    
  