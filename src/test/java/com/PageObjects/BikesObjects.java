package com.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.Excelsheet;

public class BikesObjects extends Basepage{
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public BikesObjects(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement logo;
   
	@FindBy(xpath="//a[contains(text(),'New Bikes')]")
	WebElement NewBikesdropdown ;
	
	@FindBy(xpath="//span[normalize-space()='Upcoming Bikes']")
	WebElement Upcommingbikes;
	
	@FindBy(xpath="//select[@id='makeId']")
	WebElement ManufactureDropDown;
	
	@FindBy(xpath="//option[contains(text(),'Honda')]")
	WebElement Honda;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> Data;
	
	@FindBy(xpath="(//div[@class='b fnt-15'])[\"+i+\"]")
	WebElement cost;
	
	@FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	WebElement Homepage;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement seemoreoption;
	
	//regression
	public void verifyHondaPage()
	{
		 String expetedtitle=driver.getTitle();
		 String actualtitle="Honda Upcoming Bikes in India in India";
		if(expetedtitle.contains(actualtitle)) {
			System.out.println("its on the Honda page");
		}
		else {
			System.out.println("its not on the Honda page");
		}
	}
	
	//regression
	public void seemoreoptionMethod()
	{
		js.executeScript("arguments[0].scrollIntoView();", seemoreoption);
		js.executeScript("arguments[0].click();",seemoreoption);
	}
	
	//regression
	public void extractAllHondaData() 
	{
		for(int i=1;i<=Data.size();i++){
			String cost=driver.findElement(By.xpath("(//div[@class='b fnt-15'])["+i+"]")).getText();
			String amount=cost.replaceAll("[^0-9.]|\\.(?=.*\\.)","");
		    double num=Double.parseDouble(amount);
		    
		    int Bikeprice = (int) (num*100000);
		    	String Bikemanufacture=driver.findElement(By.xpath("(//strong[@class='lnk-hvr block of-hid h-height'])["+i+"]")).getText();
		    	String Release_date=driver.findElement(By.xpath("(//div[@class='clr-try fnt-14'])["+i+"]")).getText();
		    	System.out.println(Bikemanufacture);
		    	System.out.println(Bikeprice);
		    	System.out.println(Release_date);
		    	System.out.println("==========");   
		}
	}
	
	//regression
	public void HomePage() {
		logo.click();
	}
	
	
	
	// smoke verifying weather New bikes tab in the toolbar of the home page
	public void verifyNewBikesdropdown(String str) 
	{
		try{
			Assert.assertTrue(NewBikesdropdown.isDisplayed());
			}
			catch(Exception e){
				System.out.println("dropdown not available");
			}
		
	}
	
	// smoke verifying the upcomming bikes in the New Bikes dropdown in the home page
	public void verifyUpcommingbikes(String str1) 
	{
		try{
			Assert.assertTrue(Upcommingbikes.isDisplayed());
			}
			catch(Exception e){
				System.out.println("Upcommingbikes not available");
			}
	}
	
	public void VerifyUpcommingBikesPage()
	{
		String ExpPageTitle=driver.getTitle();
		String actPageTitle="Upcoming Bikes in India in India";
		if(ExpPageTitle.contains(actPageTitle)) {
			System.out.println("its navigated to the page");
		}
		else {
			System.out.println("its not navigated to the page");
		}
	}
	
	//moving to the New Bikes element
	public void NewBikesdropdownMethod() 
	{
		Actions aobj = new Actions(driver);
		aobj.moveToElement(NewBikesdropdown).build().perform();
	}
	
	
	//clicking the upcomming bikes tab in the new bikes dropdown
	public void UpcommingbikesMethod() 
	{
		Upcommingbikes.click();
	}
	
	//choosing the manufacture dropdown
	public void ManufactureDropDownMethod()
	{
		ManufactureDropDown.click();
	}
	
	//selecting the Bike model as honda
	public void HondaMethod()
	{
		Honda.click();
	}	
	
	

	//Extracting the honda bikes data which are less that or equal to 4lacks
	public void ExtractData() throws IOException
	{
		int row=1;
		
		for(int i=1;i<=Data.size();i++){
			String cost=driver.findElement(By.xpath("(//div[@class='b fnt-15'])["+i+"]")).getText();
			String amount=cost.replaceAll("[^0-9.]|\\.(?=.*\\.)","");
		    double num=Double.parseDouble(amount);
		    
		    int Bikeprice = (int) (num*100000);
		    if(Bikeprice<=400000) {
		    	String Bikemanufacture=driver.findElement(By.xpath("(//strong[@class='lnk-hvr block of-hid h-height'])["+i+"]")).getText();
		    	String Release_date=driver.findElement(By.xpath("(//div[@class='clr-try fnt-14'])["+i+"]")).getText();
		    	System.out.println("manufacture :"+Bikemanufacture);
		    	System.out.println("cost :"+Bikeprice);
		    	System.out.println(Release_date);
		    	System.out.println("===================");
		        Excelsheet.setCellData(file, "BikesData" , row, 0, Bikemanufacture);
		       
		       Excelsheet.setCellData(file, "BikesData", row, 1, Bikeprice);
		        
		       Excelsheet.setCellData(file, "BikesData", row, 2, Release_date);
		       row=row+1;
		        
		    	try {
		    		driver.findElement(By.xpath("//span[@class=\"zw-cmn-loadMore\"]")).click();
		    	}catch(Exception e) {
		    		
		    	}
		    }
		    
		}
	}
	
	//navigating back to the home page
	public void NavigateHomePage()
	{
		Homepage.click();
	}
	
}
