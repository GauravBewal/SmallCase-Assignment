package commonUtilities;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.nio.entity.FileEntityProducer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Selectors {

	WebDriver driver;

	public By FPrice1 = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a[3]/div[1]/div[1]");
	public By FTotalPrice = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[3]/div/span");
	public By FProductDiv1 = By.xpath("//a[contains(text(), 'Motorola Escape 210 with Google Assistant Bluetooth Hea...')]");
	public By FProductDiv2 = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]");
	public By AProductDiv1 = By.xpath("//span[contains(text(), 'Motorola Escape 210 Over-Ear Bluetooth Headphones with Alexa (Black)')]");
	public By IncQuantity = By.xpath("//button[text()='+']");
	public By APrice1 = By.id("priceblock_ourprice");
	public By APrice2 = By.id("");
	public By AddToCart = By.id("add-to-cart-button");
	public By AddToCart2 = By.id("hlb-view-cart-announce");
	public By ATotalPrice = By.id("sc-subtotal-amount-buybox");

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "LM6RPg")
	public WebElement flipkartSearchBar;
	
	@CacheLookup
	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	public WebElement popup;
	
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	public WebElement amazonSearchBar;


	public Selectors (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver FlipkartSearch () {
		// Go to https://www.flipkart.com
		driver.get("https://www.flipkart.com");

		// Search for an item
		flipkartSearchBar.sendKeys("Motorola Escape 210", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Closing the popup and click on the first item in the list");
		popup.click();
		return driver;
	}

	public WebDriver AmazonSearch () throws InterruptedException {
		// Go to https://www.amazon.in
		driver.get("https://www.amazon.in/");
		
		// Search for an item.
		amazonSearchBar.sendKeys("Motorola Escape 210", Keys.ENTER);
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}


}
