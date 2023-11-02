package introduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Cls42_WebTableSortingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//sort the veg name in alphabetical order by clicking veg heading
		//ensure the list is sorted
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> ElementList= driver.findElements(By.xpath("//tr/td[1]"));
		List<String> Elementnames= ElementList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> SortedElementnames=  Elementnames.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(Elementnames.equals(SortedElementnames));
		
		//Find the price of Beans
		List<String> price= ElementList.stream().filter(s->s.getText().contains("Beans")).map(s->getVegPrice(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println("Bean's Price= "+ a));
		
		
		//pagination 
		//find the price of rice
		List<String> priceRice;
		do {
		List<WebElement> Element= driver.findElements(By.xpath("//tr/td[1]"));
		priceRice= Element.stream().filter(s->s.getText().contains("Rice")).map(s->getVegPrice(s)).collect(Collectors.toList());
		priceRice.forEach(a->System.out.println("Rice's Price= "+ a));
		if(priceRice.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(priceRice.size()<1);
		
		//searching filter field
		driver.findElement(By.id("search-field")).sendKeys("Wheat");
		List<WebElement> Veggies= driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> ListWheat= Veggies.stream().filter(s->s.getText().contains("Wheat")).collect(Collectors.toList());
		Assert.assertEquals(Veggies.size(),ListWheat.size());
		
	}
  
	public static String getVegPrice(WebElement s) {
		
		String vegPrice= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return  vegPrice;
	}
	
	
	
}
