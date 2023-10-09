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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Cls19_Synchronizationwait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		String[] itemsNeeded= {"Brocolli","Cauliflower","Beetroot"};
		addItems(driver,itemsNeeded);
		checkout(driver);
		
	}
		
		
	
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
			
			int j=0;
			List<WebElement> allProductsName= driver.findElements(By.className("product-name"));
			
			for(int i=0;i<allProductsName.size();i++)
			{
				String ProductName= allProductsName.get(i).getText();
				String[] SplitProduct= ProductName.split("-");
				String Product=SplitProduct[0].trim();
				List<String> items=Arrays.asList(itemsNeeded);
				
				if(items.contains(Product)) {
					
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					j++;
					
					if(j==itemsNeeded.length) {
						break;
					}
				}
			}
			
		}
	
	
	public static void checkout(WebDriver driver) {
		
		
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));//explicit wait object creation
		
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		//we may have to use implicitwait here. when it is declared globally on step 20, every lines under that wait will get wait time
		//First checked with implicit wait and then explict wait.
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("Rahulshetty");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
		
		
		
	}
	
	

