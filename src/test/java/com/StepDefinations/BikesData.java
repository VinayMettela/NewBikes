package com.StepDefinations;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.PageObjects.BikesObjects;
import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BikesData {
		 BikesObjects bo = new BikesObjects(driver);
		public static WebDriver driver=Baseclass.getDriver();
		
		
		@Given("The user should be on the https:\\/\\/www.zigwheels.com website")
		public void the_user_should_be_on_the_https_www_zigwheels_com_website() throws IOException {
			bo=new BikesObjects(Baseclass.getDriver());
		}

		@When("user navigates to the New Bikes")
		public void user_navigates_to_the_new_bikes() {

			bo.NewBikesdropdownMethod();
			
		}

		@Then("user clicks on the Upcomming Bikes")
		public void user_clicks_on_the_upcomming_bikes() {
			bo.UpcommingbikesMethod();
		    
		}

		@Then("user the manaufacture dropdown and select Honda")
		public void user_the_manaufacture_dropdown_and_select_honda() {
			
		    bo.ManufactureDropDownMethod();
		    bo.HondaMethod();
		}

		@Then("Extract the data of bikes less than four lacks")
		public void extract_the_data_of_bikes_less_than_four_lacks() throws IOException {
		    
			bo.ExtractData();
			bo.NavigateHomePage();
		}
		
	    //smoke
		@Then("Checks whether {string} is present in the header section")
		public void checks_whether_is_present_in_the_header_section(String string) {
		    bo.verifyNewBikesdropdown(string);
		}
		
        //smoke
		@Then("Checks whether {string} is present in the New Bikes dropdown")
		public void checks_whether_is_present_in_the_new_bikes_dropdown(String string) {
		    bo.verifyUpcommingbikes(string);
		}
        
		//smoke
		@Then("verify the navigated to the Upcomming Bikes page")
		public void verify_the_navigated_to_the_upcomming_bikes_page() {
		    bo.VerifyUpcommingBikesPage();
		}
		
		//regression
		@Given("user is on the Honda bikes page")
		public void user_is_on_the_honda_bikes_page() {
		   bo.verifyHondaPage();
		    
		}
        
		//regression
		@When("user clicks on the see more option")
		public void user_clicks_on_the_see_more_option() {
		    bo.seemoreoptionMethod();
		}

		//regression
		@When("user stores the information of all upcoming Honda bikes")
		public void user_stores_the_information_of_all_upcoming_honda_bikes() {
		    bo.extractAllHondaData();
		}

		//regression
		@Then("User should be redirected to the Home page")
		public void user_should_be_redirected_to_the_home_page() {
		    bo.HomePage();
			
		}
}
