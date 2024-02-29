package com.StepDefinations;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.PageObjects.Basepage;
import com.PageObjects.EmailVerifactionObjects;
import Factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailVerification {
	EmailVerifactionObjects obj = new EmailVerifactionObjects(driver);
	public static WebDriver driver=Baseclass.getDriver();
	@Given("The user should be on the zigwheels.com  Home page")
	public void the_user_should_be_on_the_zigwheels_com_home_page() throws IOException {
		obj=new EmailVerifactionObjects(Baseclass.getDriver());
		Basepage basepage = new Basepage(driver);
		basepage.TitleVerification();
	}
    
	@When("user click on the login tab")
	public void user_click_on_the_login_tab() {
	    obj.loginbuttonMethod();
	}

	@Then("user clicks on the google")
	public void user_clicks_on_the_google() {
	    obj.googletabMethod();
	}

	@Then("Enters the invalid details")
	public void enters_the_invalid_details() throws InterruptedException, IOException {
	    obj.emialsearchboxMethod();
	   
	}

	@Then("Extract the error information")
	public void extract_the_error_information() throws IOException {
	    obj.errormessageMethod();
	}
	
	@Then("Checks whether login\\/signup is present in the zigwheels tab")
	public void checks_whether_login_signup_is_present_in_the_zigwheels_tab() {
	    obj.loginbuttoncheck();
	}

	@Then("User should be navigated to login\\/register tab")
	public void user_should_be_navigated_to_login_register_tab() {
		String acttitle="Sign in - Google";
		String exptitle=obj.verifygoogletabMethod();
		if(acttitle.contains(exptitle)) {
			System.out.println("navigated to the login page");
		}
		else {
			System.out.println("not navigated to the login page");
		}
	}
	
	//regression
		@Then("user clicks on the facebook")
		public void user_clicks_on_the_facebook() {
			obj.facebookMethod();
		}
	
	
	//regression
	@Then("User should be navigated to the login page")
	public void user_should_be_navigated_to_the_login_page() {
	    obj.facebooknavigation();
	}
	
	//regression
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    obj.facebookpage();
	}
	
	
		
	//regression
	@Then("User checks whether the error message is displayed")
	public void user_checks_whether_the_error_message_is_displayed() {
	    obj.validationfacebookaccount();
	}
	
	
}
