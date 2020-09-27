package testCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.CommonFunctions;
import commonUtilities.Selectors;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 extends CommonFunctions{
	
	public String flipkartPrice;
	public String amazonPrice;
	public Float flip;
	public WebDriverWait wait = null;
	public WebDriver driver = null;
	public ArrayList<String> tabs;
	Selectors selectors = null;
	
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		selectors = new Selectors(driver);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void Flipkart() throws Exception{
		
		// Go to https://www.flipkart.com
		// Search for an item
		driver = selectors.FlipkartSearch();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.FPrice1));
		flipkartPrice = driver.findElement(selectors.FPrice1).getText();
		System.out.println(flipkartPrice);
		
		// Print Price of the item
		flip = FilterPrice(flipkartPrice);
		System.out.println("Flipkart Price - " + flip);
		driver.findElement(selectors.FProductDiv1).click();
		Thread.sleep(2000);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		
		// Add to cart in guest mode
		driver.switchTo().window(tabs.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.FProductDiv2));
		driver.findElement(selectors.FProductDiv2).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.FTotalPrice));
		flipkartPrice = driver.findElement(selectors.FTotalPrice).getText();
		
		// Increase Quantity by 1.
		driver.findElement(selectors.IncQuantity).click();
		Thread.sleep(4000);
		
		// Print the New Price
		flipkartPrice = driver.findElement(selectors.FTotalPrice).getText();
		flip = FilterPrice(flipkartPrice);
		System.out.println("New Price - " + flip);
	}

}
