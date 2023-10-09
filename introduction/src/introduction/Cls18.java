package introduction;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls18 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		int j = 0;

		// 3. when you want to add multiple products

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot" };

		// 1. adding all products name into list
		List<WebElement> allProductsName = driver.findElements(By.cssSelector("h4.product-name"));

		// 2.Iterate each product name and when you find the desired pdct name click add
		// to cart

		for (int i = 0; i < allProductsName.size(); i++) {

			String productName = allProductsName.get(i).getText();
			// 6. productName should be same as itemsNeeded
			// but here, lets say 1st item needed is Brocolli, but product name is Brocolli
			// - 1kg
			// so we have to split the name into Brocolli only
			String[] splittedPdctNames = productName.split("-");
			String trimmedPdctName = splittedPdctNames[0].trim();

			// 4. compare products with itemsNeeded
			// 5. we need to convert array to arraylist

			List<String> items = Arrays.asList(itemsNeeded);

//			if(productName.contains("Cucumber")) {
			if (items.contains(trimmedPdctName)) {

				j++;
				// 7. when we use xpath by text it will click tomoto instead of beetroot.
				// Because once brocolli added
				// the text will change to added. so this xpath wouldn't work. Hence we should
				// add another xpath
				// that uniquely identify the add to cart button

				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// 8. Once we iterate all the itemsneeded we don't need to check all other
				// items. We can end the iteration
				if (j == itemsNeeded.length) {
					break;
				}

			}
		}

	}

}
