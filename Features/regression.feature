Feature: Identify New Bikes

  @Regression
  Scenario: Navigating to the Honda Bikes page
    Given The user should be on the zigwheels.com website Home page	
    When user navigates to the New Bikes
    Then user clicks on the Upcomming Bikes
    And user the manaufacture dropdown and select Honda
    
    
  @Regression
  Scenario: Extracting the Honda Bikes data
   Given user is on the Honda bikes page
   When user clicks on the see more option
   And user stores the information of all upcoming Honda bikes
	 Then User should be redirected to the Home page
	 
	
	@Regression	
	Scenario Outline: Navigating to the Used Cars in that location
		Given The user should be on the zigwheels.com website Home page	
		When User clicks on the "<location name>" button in Used Cars tab
		Then User should be navigated to the Used Cars with that "<location name>"
		
		Examples:
		| 	location name		|
		|		Delhi						|
		|		Hyderabad				|
		|		Mumbai					|
		|		Bangalore				|
		|		Jaipur					|
		|		Chennai					|
		|		Kolkata					|
		|		Pune						|
		|		Ahmedabad				|
		

		
	@Regression
	Scenario: Navigating to the Sign in tab
		Given user click on the login tab
		When user clicks on the facebook
		Then User should be navigated to the login page
 
	@Regression
	Scenario: Verifing the error message is displayed in Sign in tab
		Given user is on the login page
		Then User checks whether the error message is displayed



		
	
	 
	
	

  