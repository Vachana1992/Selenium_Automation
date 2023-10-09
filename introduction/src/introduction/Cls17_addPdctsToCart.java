package introduction;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cls17_addPdctsToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		int j=0;
		String[] vegName= {"Cucumber","Beetroot","Brocolli"};
		
		List<WebElement> pdctName= driver.findElements(By.cssSelector("h4.product-name"));
		
		
		
		for(int i=0;i<pdctName.size();i++) {
			
			String name= pdctName.get(i).getText();
			String[] nameVeg=name.split("-");
			String veggie=nameVeg[0].trim();
			List itemsNeeded= Arrays.asList(vegName);
			if(itemsNeeded.contains(veggie) ){
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==vegName.length) {
					break;
				}
			}
		}
		

	}

}
