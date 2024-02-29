Feature: Identify New Bikes
  
  @Smoke
  Scenario: Verifying the New bikes tab in the Home page
    Given The user should be on the zigwheels.com website Home page
		Then Checks whether "<tab name>" is present in the header section
		
		Examples:
		|		tab name		|
		|		New Bikes		|
		
	@Smoke	
	Scenario: Verifying the dropdown of New Bikes
		Given The user should be on the zigwheels.com website Home page
		When user navigates to the New Bikes
		Then Checks whether "<button name>" is present in the New Bikes dropdown
		
		Examples:
		|		button name			|
		|		Upcoming Bikes	|
		
		
	@Smoke
	Scenario: Verifying the navigation to the upcomming bikes
		Given The user should be on the zigwheels.com website Home page
		When user clicks on the Upcomming Bikes
		Then verify the navigated to the Upcomming Bikes page
		
		
	@smoke	
	Scenario: Verifying the Used cars tab in the Home page
    Given The user should be on the zigwheels.com website Home page
		Then verify "Used Cars" is present in the header section of the page
		
		
	
	@Smoke	
	Scenario: Verifying the dropdown of Used cars
		Given The user should be on the zigwheels.com website Home page
		When user navigates to the Used cars dropdown
		Then Checks whether The LOcation "Chennai" is present in the  dropdown
				
	@Smoke
	Scenario: Verifying the navigation to the Used cars
		Given The user should be on the zigwheels.com website Home page
		When user clicks on the Chennai
		Then User should be navigated to Used cars tab
		
	@Smoke
	Scenario: Verifying the login/signup button in zigwheels
		Given The user should be on the zigwheels.com website Home page
		Then Checks whether login/signup is present in the zigwheels tab
		
	@Smoke
	Scenario: Navigating to the login/register tab
		Given The user should be on the zigwheels.com website Home page
		When user click on the login tab
		Then User should be navigated to login/register tab
		
		
	