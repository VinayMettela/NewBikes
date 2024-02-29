package com.PageObjects;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Excelsheet;

public class CarsDataObjects extends Basepage{
	public static int inc=1;
	String file = System.getProperty("user.dir")+"/src/test/resources/Excel/NewBikes.xlsx";

	
	public CarsDataObjects(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="(//a[text()='Used Cars']/following-sibling::ul//ul)[2]/li")
	List<WebElement> cities;
	
	@FindBy(xpath="//div[@class=\"col-lg-12 pt-20 pl-25 pr-25\"]/h1")
	WebElement carspagetitle;
	
	@FindBy(xpath="//a[contains(text(),'Used Cars') and @class='c-p']")
	WebElement UsedCars;
	
	@FindBy(xpath="//span[contains(text(),'Chennai') and @onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement ClickChennai;
	
	@FindBy(xpath="//input[@class='carmmCheck']")
	List<WebElement> popularModellist;
	
	@FindBy(xpath="//input[@class='carmmCheck']")
	List<WebElement> popularmodelslst;
	
	@FindBy(xpath="//a[@data-track-label='Car-name']")
	List<WebElement> carslst;
	
	@FindBy(xpath="//span[@class='zw-cmn-price n pull-left mt-3']")
	List<WebElement> carsprice;
	
	@FindBy(xpath="//span[@class=\"zc-7 fnt-14 uLm block\"]")
	List<WebElement> carslocation;
	
	
	//verifying the tab of the used cars in the toolbar
	public void VerifyUsedCars(String str1) {

		if(UsedCars.isDisplayed()) {
			System.out.println("Used cars is available");
		}
		else {
			System.out.println("Used cars is not available");
		}
	}
	
	//verifying the location chennai is available in the used cars dropdown
	public void VerifyClickChennai(String str1) {
		
		if(ClickChennai.isDisplayed()) {
			System.out.println("chennai is available");
		}
		else {
			System.out.println("chennai is not available");
		}
	}
	
	//verifying the navigation to the page of used cars in chennai
	public void verifyChennaiNavigation() {
		String exptitle=driver.getTitle();
		String acttitle="Used Cars in Chennai";
		if(exptitle.contains(acttitle)) {
			System.out.println("navigates to the used cars in chennai page");
		}
		else {
			System.out.println("its not navigates to the used cars in chennai page");
		}
		
	}

	//Hower mouse to the used cars ETE
	public void UsedCarsMethod() 
	{
		Actions a = new Actions(driver);
		a.moveToElement(UsedCars).build().perform();;
	}
	
	//selecting the chennai ETE
	public void ClickChennaiMethod()
	{
		ClickChennai.click();
	}
	
	//selecting the each checkbox of popular models and Extracting the data - ETE
	public void popularmodelslstMethod() throws InterruptedException, IOException {
		int j,row=1;
		for(int i=0;i<popularmodelslst.size();i++) {
 
			
	    	JavascriptExecutor js =(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click()",popularmodelslst.get(i));

	    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    	Thread.sleep(10000);
		    
		    
 
		    for(j=0;j<carslst.size();j++)  { 
		    	Excelsheet.setCellData(file, "CarsData", row, 0, carslst.get(j).getText());
		    	
	    		System.out.println(j+" "+carslst.get(j).getText());
		    	
		    	Excelsheet.setCellData(file, "CarsData", row, 1, carsprice.get(j).getText());
		    	
		    	System.out.println(carsprice.get(j).getText());
		        try {
		        	
		        	Excelsheet.setCellData(file, "CarsData", row, 2, carslocation.get(j).getText());
		        	System.out.println(carslocation.get(j).getText());
		        }catch(Exception e){
		        	
		        	Excelsheet.setCellData(file, "CarsData", row, 2, "Not available");
		        	System.out.println("not available");
		        	//System.out.println("=================");
		        }
		        row+=1;
	    		
	    }
		    row+=1;
		    js.executeScript("arguments[0].click()",popularmodelslst.get(i));
	    	Thread.sleep(10000);
	    }
	}
	
	//regression
	public void cityclick(String c) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Actions obj = new Actions(driver);
		int size = cities.size();
		for (int i = 0; i < size; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			obj.moveToElement(UsedCars).perform();
			if(c.equalsIgnoreCase("Delhi") || c.equalsIgnoreCase("Mumbai")) {
				try {
					WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
					wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"oneTapAlternateLoginPopup\"]//div[@class=\"clr\"]"))));
					wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"oneTapAlternateLoginPopup\"]//div[@class=\"clr\"]"))));
				}catch(Exception e) {	
				}
				}
			if (c.equalsIgnoreCase(cities.get(i).getText())) {
				wait.until(ExpectedConditions.elementToBeClickable(cities.get(i)));
				obj.moveToElement(cities.get(i)).click().perform();
				break;
			}
		}
	}
	
	//regression
	public void carsPageNavigation(String str)
	{
		
		String pagetitle=carspagetitle.getText();
		System.out.println(pagetitle);
	}
	
	
	
	
}