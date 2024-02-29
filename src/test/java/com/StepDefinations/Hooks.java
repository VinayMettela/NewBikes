package com.StepDefinations;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static  WebDriver driver;
	  static Properties p;
  
 @BeforeAll
 public static void setup() throws IOException, AWTException 
 {
 	driver=Baseclass.getWebDriver();
 	p=Baseclass.getProperties();
 	    	
 	driver.get(p.getProperty("appURl"));
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 	driver.manage().window().maximize();
 	driver.manage().deleteAllCookies();

 }
 
 @After
 public static void addScreenshot(Scenario scenario)
 {
     if(!scenario.isFailed())
     {
     	TakesScreenshot ts=(TakesScreenshot) driver;
     	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
     	scenario.attach(screenshot, "image/png",scenario.getName());
     }
 }
 
 @AfterAll
 public static void teardown() {
	 driver.quit();
 }
}
