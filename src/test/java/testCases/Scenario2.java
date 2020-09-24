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

public class Scenario2 extends CommonFunctions{

	public String flipkartPrice;
	public String amazonPrice;
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
		flipkartPrice = driver.findElement(selectors.FPrice1).getText();
		
		// Print Price of the item
		System.out.println("Flipkart Price - " + FilterPrice(flipkartPrice));
		driver.findElement(selectors.FProductDiv1).click();
		Thread.sleep(2000);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		
		// Add to cart in guest mode
		driver.switchTo().window(tabs.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.FProductDiv2));
		driver.findElement(selectors.FProductDiv2).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.FTotalPrice));
		flipkartPrice = driver.findElement(selectors.FTotalPrice).getText();
		
		// Print the Price
		System.out.println("Print the Price, Flipkart - " + FilterPrice(flipkartPrice));

		// Go to https://www.amazon.in
		// Search for an item.
		driver = selectors.AmazonSearch();

		// Click on the exact Item as in Flipkart.
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.AProductDiv1));
		driver.findElement(selectors.AProductDiv1).click();
		Thread.sleep(2000);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("Switch to third tab");
		driver.switchTo().window(tabs.get(2));
		amazonPrice = driver.findElement(selectors.APrice1).getText();
		
		// Print the Price.
		System.out.println("Amazon Price - " + FilterPrice(amazonPrice));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.AddToCart));
		
		// Add to cart(in guest Mode).
		driver.findElement(selectors.AddToCart).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.AddToCart2));
		
		// Go to Cart.
		driver.findElement(selectors.AddToCart2).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectors.ATotalPrice));
		amazonPrice = driver.findElement(selectors.ATotalPrice).getText();
		
		Float flip = FilterPrice(flipkartPrice);
		Float amazon = FilterPrice(amazonPrice);
		
		// Print the Price
		// Compare both the Prices.
		// Print which site is giving Cheaper rate
		System.out.println("Print the Price, Amazon - " + amazon);
		if (flip > amazon) {
			System.out.println("Product is Cheaper in Amazon - " + amazon);
		}else if (flip < amazon) {
			System.out.println("Product is Cheaper in Flipkart - " + flip);
		}else {
			System.out.println("Product have same price in Both Sites. - " + amazon);
		}
	}
	
}
