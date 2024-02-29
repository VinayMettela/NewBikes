package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class Basepage {
	WebDriver driver;
	 String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";

	int col=0;
	
	public Basepage(WebDriver driver){
		 this.driver=driver;
		
	     PageFactory.initElements(driver,this);
	}
	
	//Verifying the title of the home page
	public void TitleVerification() throws IOException {
		
		String title=driver.getTitle();
		System.out.println(title);
		
	}
	
	
	
}
