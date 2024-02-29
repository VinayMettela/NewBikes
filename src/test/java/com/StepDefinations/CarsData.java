package com.StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.PageObjects.Basepage;
import com.PageObjects.CarsDataObjects;

import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarsData {

	CarsDataObjects co = new CarsDataObjects(driver);
	public static WebDriver driver=Baseclass.getDriver();
	@Given("The user should be on the zigwheels.com website Home page")
	public void the_user_should_be_on_the_zigwheels_com_website_home_page() throws IOException {
		co=new CarsDataObjects(Baseclass.getDriver());
		Basepage basepage = new Basepage(driver);
		basepage.TitleVerification();
		
	}

	@When("user navigates to the Used cars dropdown")
	public void user_navigates_to_the_used_cars_dropdown() {
	    
		co.UsedCarsMethod();
	}

	@Then("user clicks on the Chennai")
	public void user_clicks_on_the_chennai() {
	    co.ClickChennaiMethod();
		
	}

	@Then("Extract the data under the popular models")
	public void extract_the_data_under_the_popular_models() throws InterruptedException, IOException {
		co.popularmodelslstMethod();
		
	}
	
	//smoke
	@Then("verify {string} is present in the header section of the page")
	public void verify_is_present_in_the_header_section_of_the_page(String string) {
	    co.VerifyUsedCars(string);
	}

	//smoke
	@Then("Checks whether The LOcation {string} is present in the  dropdown")
	public void checks_whether_the_l_ocation_is_present_in_the_dropdown(String string) {
	   co.VerifyClickChennai(string);
	}

	//smoke
	@Then("User should be navigated to Used cars tab")
	public void user_should_be_navigated_to_used_cars_tab() {
	    co.verifyChennaiNavigation();
	}
	
	//Regresion
	@When("User clicks on the {string} button in Used Cars tab")
	public void user_clicks_on_the_button_in_used_cars_tab(String string) {
	    
		co.cityclick(string);
		
	}

	//Regresion
	@Then("User should be navigated to the Used Cars with that {string}")
	public void user_should_be_navigated_to_the_used_cars_with_that(String string) {
	    
		co.carsPageNavigation(string);
	}
	
	
	
}
