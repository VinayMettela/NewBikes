package com.PageObjects;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Excelsheet;

public class EmailVerifactionObjects extends Basepage {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	String parenttab;
	
	public EmailVerifactionObjects(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement facebookmail;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement facebokpassword;
	
	@FindBy(xpath="//div[@class='pam login_error_box _9ay3 uiBoxRed']")
	WebElement facebookerror;
	
    @FindBy(xpath="//div[@class=\"lgn-sc fb c-p txt-l pl-30 pr-30\"]")
    WebElement facebook;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),'Google')]")
	WebElement googleSignIn;
	
	@FindBy(id="forum_login_wrap_lg")
	WebElement loginbutton;
	
	@FindBy(id="identifierId")
	WebElement emialsearchbox;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement sumbitbutton;
	
	@FindBy(id="report_submit_close_login")
	WebElement closetab;
	
	@FindBy(xpath="//*[contains(text(),'Couldn’t find your Google Account')]")
	WebElement errormessage;
	
	//verifying the login button
	public void loginbuttoncheck()
	{
		logo.click();
		if(loginbutton.isDisplayed()) {
			System.out.println("login button is available");
		}
		else {
			System.out.println("login button is not available");
		}
	}
	
	//verifying the navigation page
	public String verifygoogletabMethod()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		googleSignIn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		return driver.getTitle();
	}
	
	//click the login/signup button in the Home page
	public void loginbuttonMethod()
	{
		logo.click();
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//Selecting google as the login method
	public void googletabMethod()
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		googleSignIn.click();
		parenttab = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	//passing the invalid details 
	public void emialsearchboxMethod() throws IOException
	{
		String email=Excelsheet.getCellData(file, "sheet1", 1, 0);
		emialsearchbox.sendKeys(email,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
	}
	
	//capturing the Error message.
	public void errormessageMethod() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String errormsg=errormessage.getText();
		System.out.println("error message:"+errormsg);
		Excelsheet.setCellData(file, "Email verification", 1, 0, errormsg);
		
		
		
	}
	
	//regression
	public void facebookMethod() {
		facebook.click();
	}
	
	//regression
	public void facebooknavigation()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
	}	
	
	//regression
	public void facebookpage() {
		String exppagetitle=driver.getTitle();
		String actpagetitle="exppagetitle";
		if(exppagetitle.equalsIgnoreCase(actpagetitle)) {
			System.out.println("navigated to correct facebook");
		}
		else {
			System.out.println("navigated to incorrect facebook");
		}
	}
	
	//regression
	public void validationfacebookaccount()
	{
		facebookmail.click();
		facebookmail.sendKeys("wer234@gmail.com");
		facebokpassword.click();
		facebokpassword.sendKeys("123456",Keys.ENTER);
		System.out.println(facebookerror.getText());
	
//		driver.switchTo().window(parenttab);
//		closetab.click();
	}
	
	
	
	
}
