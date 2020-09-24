package commonUtilities;

import org.openqa.selenium.WebDriver;

public class CommonFunctions {
	
	public String filterPrice;

	public Float FilterPrice(String price) {

		filterPrice = price.replaceAll("[^\\d+\\.]", "");
		filterPrice = filterPrice.trim();
		System.out.println(filterPrice);
		return Float.parseFloat(filterPrice);
	}

}
