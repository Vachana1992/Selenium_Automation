package introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cls20_Assignment_Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
        driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
//		Thread.sleep(5000);
		WebDriverWait w= new WebDriverWait(driver,Duration.ofMillis(7000));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		
	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control']")));
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		System.out.println(driver.findElement(By.id("terms")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.my-4")));
		

		String[] ItemsNeeded= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		addItemsTocart(driver,ItemsNeeded);
		
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	
		}
	
	
	public static void addItemsTocart(WebDriver driver,String[] ItemsNeeded) {
		
		int j=0;
		
		
		List<WebElement> productdisplayed=driver.findElements(By.cssSelector("h4.card-title"));
		
		
		for(int i=0;i<productdisplayed.size();i++) {
			
			String product= productdisplayed.get(i).getText();
			
			List<String> items= Arrays.asList(ItemsNeeded);
			
			if(items.contains(product)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				
				if(j==product.length()) {
					break;
				}
			}
		}
		
		
		
	}

}
